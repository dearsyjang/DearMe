package com.dearme.demo.domain.user.dto.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequestDto {
    @NotBlank
    private String id;
    @NotBlank
    private String pw;
}
