package com.dearme.demo.domain.review.dto;

import com.dearme.demo.domain.review.entity.Review;
import lombok.Data;

@Data
public class ReviewSaveRequestDto {
    private String counselorid;
    private Long value;
    private String contents;
    public Review toReviewEntity(){
        return Review.builder()
                .counselorid(this.counselorid)
                .value(this.value)
                .contents(this.contents)
                .build();
    }
}
