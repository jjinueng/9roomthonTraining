package com.goorm.tricountsonic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
/*
* 멤버 저장을 위해 필요
* */

public class Member {
    private Long id;
    private String loginId;
    private String name;

    @JsonIgnore
    private String password;
}
