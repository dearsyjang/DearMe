package com.dearme.demo.domain.videodiary.dto;

import com.dearme.demo.domain.videodiary.entity.VideoDiary;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class PostVideoDiaryRequestDto {
    @NotBlank(message = "title은 비워둘 수 없습니다.")
    private String title;
    @NotBlank(message = "realFileName은 비워둘 수 없습니다.")
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
