package com.dearme.demo.domain.user.dto.counselorprofile;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UpdateCertificateRequestDto {
    @NotBlank(message = "id는 비워둘 수 없습니다.")
    private Long id;
    @NotBlank(message = "contents는 비워둘 수 없습니다.")
    private String contents;
}
