package com.goorm.tricountsonic.service;

import static java.util.stream.Collectors.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.goorm.tricountsonic.dto.BalanceResult;
import com.goorm.tricountsonic.dto.ExpenseResult;
import com.goorm.tricountsonic.model.Member;
import com.goorm.tricountsonic.model.Settlement;
import com.goorm.tricountsonic.repository.ExpenseRepository;
import com.goorm.tricountsonic.repository.SettlementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SettlementService {
    private final SettlementRepository settlementRepository;
    private final ExpenseRepository expenseRepository;

    @Transactional
  public Settlement createAndJoinSettlement(String settlementName, Member member) {
    Settlement settlement = settlementRepository.create(settlementName);
    settlementRepository.addParticipantToSettlement(settlement.getId(), member.getId());
    settlement.getParticipants().add(member);
    return settlement;
  }

  public void joinSettlement(Long settlementId, Long memberId) {
      //TODO 없는 settle id, member id 요청했을때 예외처리
    settlementRepository.addParticipantToSettlement(settlementId, memberId);
  }

  public List<BalanceResult> getBalanceResult(Long settlmentId) {
      // 1. 먼저 지출정보를 가져와서 지출한 사람별로 그룹핑을 해야함
    Map<Member, List<ExpenseResult>> collected = expenseRepository.findExpensesWithMemberBySettlementId(settlmentId)
      .stream()
      .collect(groupingBy(ExpenseResult::getPayerMember));

    if (CollectionUtils.isEmpty(collected)) {
      throw new RuntimeException("정산할 정보가 없습니다.");
    }

    //2, 위를 바탕으로 각 멤버렬로 얼만큼 지출을 했는지 총합!을 나타내는 맵을 구해야함
    Map<Member, BigDecimal> memberAmountSumMap = collected.entrySet().stream()
      .collect(toMap(Map.Entry::getKey, memberListEntry ->
        memberListEntry.getValue().stream().map(ExpenseResult::getAmount)
          .reduce(BigDecimal.ZERO, BigDecimal::add)
      ));

    // 3. 정산그룹의 총 지출을 구해야함
    BigDecimal sumAmount = memberAmountSumMap.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);

    // 4. 정산그룹 총 지출에 대한 평균값을 구해야함
    BigDecimal averageAmount = sumAmount.divide(BigDecimal.valueOf(memberAmountSumMap.size()), BigDecimal.ROUND_UP);

    // 5. 각 멤버별로 지출한 돈에서 총 지출 평균값을 뺌
    Map<Member, BigDecimal> calculatedAmountMap = memberAmountSumMap.entrySet().stream()
      .collect(toMap(Map.Entry::getKey, memberBigDecimalEntry ->
        memberBigDecimalEntry.getValue().subtract(averageAmount)));


    // 6. 5의 계산 값에서 양수가 나오면 -> receiver.
    List<Map.Entry<Member, BigDecimal>> receiver = calculatedAmountMap.entrySet().stream()
      .filter(memberBigDecimalEntry -> memberBigDecimalEntry.getValue().signum() > 0)
      .sorted((o1, o2) -> o2.getValue().subtract(o1.getValue()).signum())
      .collect(toList());

    // 7. 5의 계산에서 음수 -> sender.
    List<Map.Entry<Member, BigDecimal>> sender = calculatedAmountMap.entrySet().stream()
      .filter(memberBigDecimalEntry -> memberBigDecimalEntry.getValue().signum() < 0)
      .sorted((o1, o2) -> o1.getValue().subtract(o2.getValue()).signum())
      .collect(toList());

    List<BalanceResult> balanceResults = new ArrayList<>();
    int receiverIndex = 0;
    int senderIndex = 0;


    //8. receiver/sender 맵에서 반복문을 돌면서 result 에 값을 넣어줌
    while (receiverIndex < receiver.size() && senderIndex < sender.size()) {
      BigDecimal amountToTransfer = receiver.get(receiverIndex).getValue()
        .add(sender.get(senderIndex).getValue());

      if(amountToTransfer.signum() < 0) {
        balanceResults.add(new BalanceResult(
          sender.get(senderIndex).getKey().getId(),
          sender.get(senderIndex).getKey().getName(),
          receiver.get(receiverIndex).getValue().abs(),
          receiver.get(receiverIndex).getKey().getId(),
          receiver.get(receiverIndex).getKey().getName()
        ));
        receiver.get(receiverIndex).setValue(BigDecimal.ZERO);
        sender.get(senderIndex).setValue(amountToTransfer);
        receiverIndex++;
      } else if(amountToTransfer.signum() > 0) {
        balanceResults.add(new BalanceResult(
          sender.get(senderIndex).getKey().getId(),
          sender.get(senderIndex).getKey().getName(),
          sender.get(senderIndex).getValue().abs(),
          receiver.get(receiverIndex).getKey().getId(),
          receiver.get(receiverIndex).getKey().getName()
        ));
        receiver.get(receiverIndex).setValue(amountToTransfer);
        sender.get(senderIndex).setValue(BigDecimal.ZERO);
        senderIndex++;
      } else {//평균값만큼 낸 경우
        balanceResults.add(new BalanceResult(
          sender.get(senderIndex).getKey().getId(),
          sender.get(senderIndex).getKey().getName(),
          sender.get(senderIndex).getValue().abs(),
          receiver.get(receiverIndex).getKey().getId(),
          receiver.get(receiverIndex).getKey().getName()
        ));
        receiver.get(receiverIndex).setValue(BigDecimal.ZERO);
        sender.get(senderIndex).setValue(BigDecimal.ZERO);
        receiverIndex++;
        senderIndex++;
      }
    }


    return balanceResults;
  }

}
