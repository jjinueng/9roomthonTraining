package com.goorm.tricountsonic.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ExpenseRequest {
    private String name;

    private Long settlementId;

    private Long payerMemberId;

    private BigDecimal amount;

    private LocalDateTime expenseDateTime;
}
