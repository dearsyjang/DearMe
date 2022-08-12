package com.dearme.demo.domain.user.dto.etc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewViewResponseDto {
    private Long id;
    private String nickName;
    private Long value;
    private String contents;
}
