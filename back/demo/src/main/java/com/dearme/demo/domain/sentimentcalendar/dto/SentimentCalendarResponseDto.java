package com.dearme.demo.domain.sentimentcalendar.dto;

import com.dearme.demo.domain.textdiary.entity.TextDiary;
import com.dearme.demo.domain.videodiary.dto.VideoDiaryDetailsResponseDto;
import com.dearme.demo.domain.videodiary.entity.VideoDiary;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SentimentCalendarResponseDto {
    private Integer year;
    private Integer month;
    private Integer day;
    private Long textdiaryid;
    private String textdiarysentiment;
    private Long textdiarypercentage;
    private Long videodiaryid;
    private String videodiarysentiment;
    private Long videodiarypercentage;
}
