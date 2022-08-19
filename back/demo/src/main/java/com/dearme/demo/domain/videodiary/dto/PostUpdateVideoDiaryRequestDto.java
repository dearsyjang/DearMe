package com.dearme.demo.domain.videodiary.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PostUpdateVideoDiaryRequestDto {
    @NotBlank(message = "title은 비워둘 수 없습니다.")
    private String title;
    @NotBlank(message = "contents는 비워둘 수 없습니다.")
    private String contents;
    @NotBlank(message = "sentiment는 비워둘 수 없습니다.")
    private String sentiment;

}
