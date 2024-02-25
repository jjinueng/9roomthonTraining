package com.goorm.tricountsonic.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goorm.tricountsonic.dto.ExpenseRequest;
import com.goorm.tricountsonic.dto.ExpenseResult;
import com.goorm.tricountsonic.service.ExpenseService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ExpenseController {
  private final ExpenseService expenseService;

    // 정산 추가

  @PostMapping("/expenses/add")
  public ResponseEntity<ExpenseResult> addExpenseToSettlement(
    @Valid @RequestBody ExpenseRequest expenseRequest
  ) {
    return new ResponseEntity<>(expenseService.addExpense(expenseRequest), HttpStatus.OK);
  }

}
