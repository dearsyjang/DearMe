package com.dearme.demo.domain.user.dto.user;

import lombok.Data;

@Data
public class UpdateCategoryRequestDto {
    private Long id;
    private String contents;
}
