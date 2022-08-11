package com.dearme.demo.domain.videodiary.dto;

import com.dearme.demo.domain.videodiary.entity.VideoDiary;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PostVideoDiaryRequestDto {

    private String title;
    private String realFileName;

    public VideoDiary toEntity(){
        LocalDate now = LocalDate.now();
        return VideoDiary.builder()
                .title(this.title)
                .realFileName(this.realFileName)
                .year(now.getYear())
                .month(now.getMonthValue())
                .day(now.getDayOfMonth())
                .build();
    }

}
