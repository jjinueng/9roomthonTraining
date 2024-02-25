package com.goorm.tricountsonic.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SignupRequest {
    @NotNull
    private String loginId;
    @NotNull
    private String password;
    @NotNull
    private String name;
}
