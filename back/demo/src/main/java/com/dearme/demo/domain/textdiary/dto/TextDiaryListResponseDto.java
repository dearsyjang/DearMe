package com.dearme.demo.domain.textdiary.dto;

import lombok.Data;

import java.util.List;

@Data
public class TextDiaryListResponseDto {
    List<TextDiaryDetailsResponseDto> textDiaries;
}
