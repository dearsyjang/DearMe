package com.dearme.demo.domain.videodiary.dto;

import com.dearme.demo.domain.videodiary.entity.VideoDiary;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VideoDiaryDetailsResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String sentiment;
    private String realFileName;
    private double percentage;
    private double positive;
    private double negative;
    private double neutral;
    private Integer year;
    private Integer month;
    private Integer day;


    public static VideoDiaryDetailsResponseDto of(VideoDiary entity){
        return VideoDiaryDetailsResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .contents(entity.getContents())
                .sentiment(entity.getSentiment())
                .realFileName(entity.getRealFileName())
                .percentage(entity.getPercentage())
                .positive(entity.getPositive())
                .negative(entity.getNegative())
                .neutral(entity.getNeutral())
                .year(entity.getYear())
                .month(entity.getMonth())
                .day(entity.getDay())
                .build();
    }
}
