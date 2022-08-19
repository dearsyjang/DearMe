package com.dearme.demo.domain.user.dto.counselorsearch;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CounselorSearchRequestDto {
    private String category;
    @NotNull(message = "upPrice는 비워둘 수 없습니다.")
    private Long upPrice;
    @NotNull(message = "downPrice는 비워둘 수 없습니다.")
    private Long downPrice;
    @NotNull(message = "reviewCntUp은 비워둘 수 없습니다.")
    private Boolean reviewCntUp;
    @NotNull(message = "reviewCntDown은 비워둘 수 없습니다.")
    private Boolean reviewCntDown;
    @NotNull(message = "reviewScoreUp은 비워둘 수 없습니다.")
    private Boolean reviewScoreUp;
    @NotNull(message = "reviewScoreDown은 비워둘 수 없습니다.")
    private Boolean reviewScoreDown;
    @NotNull(message = "favorite은 비워둘 수 없습니다.")
    private Boolean favorite;

}
