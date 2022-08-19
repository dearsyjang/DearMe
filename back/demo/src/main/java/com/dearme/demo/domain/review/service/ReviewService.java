package com.dearme.demo.domain.review.service;

import com.dearme.demo.domain.review.dto.ReviewSaveRequestDto;
import com.dearme.demo.domain.review.dto.ReviewSaveResponseDto;

public interface ReviewService {
    ReviewSaveResponseDto reviewSave(String id, ReviewSaveRequestDto dto);
    void reviewDelete(String id, Long reviewId);
}
