package com.dearme.demo.domain.user.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateCategoryResponseDto {
    private Long id;
    private String contents;
}