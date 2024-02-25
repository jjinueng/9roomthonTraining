package com.goorm.tricountsonic.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoginRequest {
    @NotNull
    private String loginId;
    @NotNull
    private String password;
}
