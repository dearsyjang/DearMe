package com.dearme.demo.domain.videodiary.dto;


import lombok.Data;

@Data
public class PostUpdateVideoDiaryRequestDto {
    private String title;
    private String contents;
    private String sentiment;

}
