package com.dearme.demo.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateCareerResponseDto {
    private Long id;
    private String contents;
}
