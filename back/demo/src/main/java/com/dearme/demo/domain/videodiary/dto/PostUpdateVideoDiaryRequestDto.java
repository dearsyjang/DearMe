package com.dearme.demo.domain.videodiary.dto;


import com.dearme.demo.domain.videodiary.entity.VideoDiary;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PostUpdateVideoDiaryRequestDto {
    private String title;
    private String contents;
    private String sentiment;

}
