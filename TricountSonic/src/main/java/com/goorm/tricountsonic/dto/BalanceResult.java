package com.goorm.tricountsonic.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BalanceResult {
    private Long senderMemberId;
    private String senderMemberName;
    private BigDecimal sendAmount;
    private Long receiverMemberId;
    private String receiverMemberName;
}