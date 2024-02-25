package com.goorm.tricountsonic.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goorm.tricountsonic.dto.BalanceResult;
import com.goorm.tricountsonic.model.Member;
import com.goorm.tricountsonic.model.Settlement;
import com.goorm.tricountsonic.service.SettlementService;
import com.goorm.tricountsonic.util.MemberContext;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SettlementController {
  private final SettlementService settlementService;

    // 정산 생성
  @PostMapping("/settles/create")
  public ResponseEntity<Settlement> createSettlement(@RequestParam String settlementName) {
    return new ResponseEntity<>(settlementService.createAndJoinSettlement(settlementName, MemberContext.getCurrentMember()), HttpStatus.OK);
  }

    // 정산 참여

  @PostMapping("/settles/{id}/join")
  public ResponseEntity<Void> joinSettlement(@PathVariable("id") Long settlementId) {
    settlementService.joinSettlement(settlementId, MemberContext.getCurrentMember().getId());
    return new ResponseEntity<>(HttpStatus.OK);
  }

  // 정산 결과

  @GetMapping("/settles/{id}/balance")
  public ResponseEntity<List<BalanceResult>> getSettlementBalanceResult(@PathVariable("id") Long settlmentId) {
    return new ResponseEntity<>(settlementService.getBalanceResult(settlmentId), HttpStatus.OK);
  }

}
