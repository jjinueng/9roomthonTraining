package com.goorm.tricountsonic.repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.goorm.tricountsonic.dto.ExpenseResult;
import com.goorm.tricountsonic.model.Expense;
import com.goorm.tricountsonic.model.Member;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ExpenseRepository {
    private final JdbcTemplate jdbcTemplate;

    // 지출 저장
    public Expense save(Expense expense) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("expense").usingGeneratedKeyColumns("id");

        Map<String, Object> parmas = new HashMap<>();
        parmas.put("name", expense.getName());
        parmas.put("settlement_id", expense.getSettlementId());
        parmas.put("payer_member_id", expense.getPayerMemberId());
        parmas.put("amount", expense.getAmount());
        parmas.put("expense_date_time", expense.getExpenseDateTime());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parmas));
        expense.setId(key.longValue());

        return expense;
    }

    // 정산 id로 지출 목록 + 멤버 검색
    public List<ExpenseResult> findExpensesWithMemberBySettlementId(Long settlementId) {
        String sql = "SELECT * " +
          "FROM settlement_participant " +
          "JOIN member ON settlement_participant.member_id = member.id " +
          "LEFT JOIN expense ON settlement_participant.member_id = expense.payer_member_id " +
          "AND settlement_participant.settlement_id = expense.settlement_id " +
          "WHERE settlement_participant.settlement_id = ?";
        return jdbcTemplate.query(sql, expenseResultRowMapper(), settlementId);
    }
    private RowMapper<ExpenseResult> expenseResultRowMapper() {
        return ((rs, rowNum) -> {
            ExpenseResult expenseResult = new ExpenseResult();
            expenseResult.setSettlementId(rs.getLong("settlement_participant.settlement_id"));
            BigDecimal amt = rs.getBigDecimal("expense.amount");
            //null일경우 0으로 넣어줌
            expenseResult.setAmount(amt != null ? amt : BigDecimal.ZERO);

            Member member = new Member();
            if(rs.getLong("member.id") != 0) {
                member.setId(rs.getLong("member.id"));
                member.setLoginId(rs.getString("member.login_id"));
                member.setPassword(rs.getString("member.password"));
                member.setName(rs.getString("member.name"));

                expenseResult.setPayerMember(member);
            }

            return expenseResult;
        });
    }



}
