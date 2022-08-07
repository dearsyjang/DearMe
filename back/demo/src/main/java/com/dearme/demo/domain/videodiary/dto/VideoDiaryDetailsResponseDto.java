package com.dearme.demo.domain.videodiary.dto;

import com.dearme.demo.domain.textdiary.entity.TextDiary;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VideoDiaryDetailsResponseDto {
    private Long id;
    private String title;
    private String contents;
    private Integer year;
    private Integer month;
    private Integer day;

    public static VideoDiaryDetailsResponseDto of(TextDiary entity){
        return VideoDiaryDetailsResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .contents(entity.getContents())
                .year(entity.getYear())
                .month(entity.getMonth())
                .day(entity.getDay())
                .build();
    }
}
