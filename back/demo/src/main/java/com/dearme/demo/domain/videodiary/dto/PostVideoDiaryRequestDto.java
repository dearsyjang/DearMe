package com.dearme.demo.domain.videodiary.dto;

import com.dearme.demo.domain.videodiary.entity.VideoDiary;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PostVideoDiaryRequestDto {

    private String title;
    private String realFileName;
    private String fileName;

    public VideoDiary toEntity(){
        LocalDate now = LocalDate.now();
        return VideoDiary.builder()
                .title(this.title)
                .realFileName(this.realFileName)
                .fileName(this.fileName)
                .year(now.getYear())
                .month(now.getMonthValue())
                .day(now.getDayOfMonth())
                .build();
    }

}
