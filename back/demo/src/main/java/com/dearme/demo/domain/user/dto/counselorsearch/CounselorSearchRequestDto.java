package com.dearme.demo.domain.user.dto.counselorsearch;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CounselorSearchRequestDto {
    private String category;
    @NotBlank(message = "upPrice는 비워둘 수 없습니다.")
    private Long upPrice;
    @NotBlank(message = "downPrice는 비워둘 수 없습니다.")
    private Long downPrice;
    private Boolean reviewCntUp;
    private Boolean reviewCntDown;
    private Boolean reviewScoreUp;
    private Boolean reviewScoreDown;
    private Boolean favorite;

}
