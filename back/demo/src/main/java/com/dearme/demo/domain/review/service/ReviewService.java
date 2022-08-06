package com.dearme.demo.domain.review.service;

import com.dearme.demo.domain.review.dto.ReviewCounselorViewResponseDto;
import com.dearme.demo.domain.review.dto.ReviewSaveRequestDto;
import com.dearme.demo.domain.review.dto.ReviewSaveResponseDto;
import com.dearme.demo.domain.user.dto.user.ReviewViewResponseDto;

import java.util.List;

public interface ReviewService {
    ReviewSaveResponseDto reviewSave(String id, ReviewSaveRequestDto dto);
    void reviewDelete(String id, Long reviewid);

    List<ReviewCounselorViewResponseDto> reviewCounselorView(String id);



}
