package com.dearme.demo.domain.review.dto;

import com.dearme.demo.domain.review.entity.Review;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ReviewSaveRequestDto {
    @NotNull(message = "id는 비워둘 수 없습니다.")
    private Long id;
    @NotNull(message = "value는 비워둘 수 없습니다.")
    private Long value;
    @NotBlank(message = "contents는 비워둘 수 없습니다.")
    private String contents;
    public Review toReviewEntity(){
        return Review.builder()
                .value(this.value)
                .contents(this.contents)
                .build();
    }
}
