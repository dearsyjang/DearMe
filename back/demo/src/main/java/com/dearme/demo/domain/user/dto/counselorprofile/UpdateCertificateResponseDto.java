package com.dearme.demo.domain.user.dto.counselorprofile;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateCertificateResponseDto {
    private Long id;
    private String contents;
}
