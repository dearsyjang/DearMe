package com.dearme.demo.domain.user.dto;

import lombok.Data;

@Data
public class UpdateCategoryRequestDto {
    private Long id;
    private String contents;
}
