package com.dearme.demo.domain.user.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewViewResponseDto {
    private String nickname;
    private Long value;
    private String contents;
}
