package com.dearme.demo.domain.user.dto;

import lombok.Data;

@Data
public class UpdateCertificateRequestDto {
    private Long id;
    private String contents;
}
