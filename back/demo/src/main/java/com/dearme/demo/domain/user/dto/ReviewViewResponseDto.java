package com.dearme.demo.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewViewResponseDto {
    private Long reviewid;
    private String nickname;
    private Long value;
    private String contents;
}
