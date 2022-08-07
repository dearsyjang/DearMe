package com.dearme.demo.domain.videodiary.dto;

import lombok.Data;

import java.util.List;

@Data
public class VideoDiaryListResponseDto {
    List<VideoDiaryDetailsResponseDto> textDiaries;
}
