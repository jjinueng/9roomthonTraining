package com.goorm.tricountsonic.service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.goorm.tricountsonic.dto.ExpenseRequest;
import com.goorm.tricountsonic.dto.ExpenseResult;
import com.goorm.tricountsonic.model.Expense;
import com.goorm.tricountsonic.model.Member;
import com.goorm.tricountsonic.model.Settlement;
import com.goorm.tricountsonic.repository.ExpenseRepository;
import com.goorm.tricountsonic.repository.MemberRepository;
import com.goorm.tricountsonic.repository.SettlementRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final MemberRepository memberRepository;
    private final SettlementRepository settlementRepository;

  // 지출 추가
  public ExpenseResult addExpense(ExpenseRequest expenseRequest) {
    //예외 처리
    Optional<Member> payer = memberRepository.findById(expenseRequest.getPayerMemberId());
    if (!payer.isPresent()) {
      throw new RuntimeException("INVALID MEMBER ID ! (PAYER)");
    }
    // 정산 존재 여부 예외
    Optional<Settlement> settlement = settlementRepository.findById(expenseRequest.getSettlementId());
    if(!settlement.isPresent()) {
      throw new RuntimeException("INVALID SETTLEMENT ID !");
    }

    //지출 저장
    Expense expense = Expense.builder()
      .name(expenseRequest.getName())
      .settlementId(expenseRequest.getSettlementId())
      .payerMemberId(expenseRequest.getPayerMemberId())
      .amount(expenseRequest.getAmount())
      .expenseDateTime(Objects.nonNull(expenseRequest.getExpenseDateTime()) ? expenseRequest.getExpenseDateTime() : LocalDateTime.now())
      .build();
    expenseRepository.save(expense);
    return null;
  }

}
