package com.dearme.demo.domain.user.dto.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequestDto {
    @NotBlank(message = "id는 비워둘 수 없습니다.")
    private String id;
    @NotBlank(message = "pw는 비워둘 수 없습니다.")
    private String pw;
}
