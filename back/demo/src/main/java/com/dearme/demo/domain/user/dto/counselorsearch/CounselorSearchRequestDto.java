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
    @NotBlank(message = "reviewCntUp은 비워둘 수 없습니다.")
    private Boolean reviewCntUp;
    @NotBlank(message = "reviewCntDown은 비워둘 수 없습니다.")
    private Boolean reviewCntDown;
    @NotBlank(message = "reviewScoreUp은 비워둘 수 없습니다.")
    private Boolean reviewScoreUp;
    @NotBlank(message = "reviewScoreDown은 비워둘 수 없습니다.")
    private Boolean reviewScoreDown;
    @NotBlank(message = "favorite은 비워둘 수 없습니다.")
    private Boolean favorite;

}
