package com.dearme.demo.domain.videodiary.dto;

import com.dearme.demo.domain.textdiary.entity.TextDiary;
import com.dearme.demo.domain.videodiary.entity.VideoDiary;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PostVideoDiaryRequestDto {

    private String title;
    private String realfilename;
    private String filename;

    public VideoDiary toEntity(){
        LocalDate now = LocalDate.now();
        return VideoDiary.builder()
                .title(this.title)
                .realfilename(this.realfilename)
                .filename(this.filename)
                .year(now.getYear())
                .month(now.getMonthValue())
                .day(now.getDayOfMonth())
                .build();
    }

}
