package com.dearme.demo.domain.review.dto;

import com.dearme.demo.domain.review.entity.Review;
import lombok.Data;

@Data
public class ReviewSaveRequestDto {
    private String id;
    private Long value;
    private String contents;
    public Review toReviewEntity(){
        return Review.builder()
                .value(this.value)
                .contents(this.contents)
                .build();
    }
}
