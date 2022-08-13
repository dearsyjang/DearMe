package com.dearme.demo.domain.user.dto.counselorsearch;

import lombok.Data;

@Data
public class CounselorSearchRequestDto {
    private String category;
    private Long upPrice;
    private Long downPrice;
    private Boolean reviewCntUp;
    private Boolean reviewCntDown;
    private Boolean reviewScoreUp;
    private Boolean reviewScoreDown;
    private Boolean favorite;
}