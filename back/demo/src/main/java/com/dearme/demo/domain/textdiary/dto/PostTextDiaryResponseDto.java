package com.dearme.demo.domain.textdiary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostTextDiaryResponseDto {
    private Long id;
    private String sentiment;
    private Long percentage;
}
