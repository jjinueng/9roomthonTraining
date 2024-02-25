package com.goorm.tricountsonic.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.goorm.tricountsonic.model.Member;
import com.goorm.tricountsonic.model.Settlement;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SettlementRepository {
    private final JdbcTemplate jdbcTemplate;

    // 정산 생성
    public Settlement create(String name) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("settlement").usingGeneratedKeyColumns("id");
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(params));
        Settlement settlement = new Settlement();
        settlement.setId(key.longValue());
        settlement.setName(name);
        return settlement;
    }


    // 유저가 정산에 참여
    public void addParticipantToSettlement(Long settlementId, Long memberId) {
        jdbcTemplate.update("INSERT INTO settlement_participant (settlement_id, member_id) VALUES (?,?)",
        settlementId, memberId);
    }


    // 정산 findById
    public Optional<Settlement> findById(Long id) {
        List<Settlement> result = jdbcTemplate.query("SELECT * FROM settlement "
          + "JOIN settlement_participant ON settlment.id = settlement_participant.settlement_id "
          + "JOIN member ON settlement_participant.member_id = member.id "
          + "WHERE settlement.id = ? ", settlementParticipantsRowMapper(), id);

        return result.stream().findAny();
    }

    private RowMapper<Settlement>  settlementParticipantsRowMapper() {
        return ((rs, rowNum) -> {
            Settlement settlement = new Settlement();
            settlement.setId(rs.getLong("settlement.id"));
            settlement.setName(rs.getString("settlement.name"));

            //List 로 매핑
            List<Member> participants = new ArrayList<>();
            do {
                Member participant = new Member(
                  rs.getLong("member.id"),
                  rs.getString("member.login_id"),
                  rs.getString("member.name"),
                  rs.getString("member.password")
                );
                participants.add(participant);
            } while (rs.next());
            settlement.setParticipants(participants);
            return settlement;
        });
    }


}
