package com.dearme.demo.domain.videodiary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostVideoDiaryResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String sentiment;
    private Long percentage;
}
