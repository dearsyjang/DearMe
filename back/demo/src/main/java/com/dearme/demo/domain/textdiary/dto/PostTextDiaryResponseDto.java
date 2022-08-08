package com.dearme.demo.domain.textdiary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class PostTextDiaryResponseDto {
    private Long id;
    private String sentiment;
    private double percentage;
    private double positive;
    private double negative;
    private double neutral;
}
