package com.dearme.demo.domain.review.controller;


import com.dearme.demo.domain.review.dto.ReviewSaveRequestDto;
import com.dearme.demo.domain.review.service.ReviewService;
import com.dearme.demo.global.common.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RequestMapping("/reviews")
@RestController
public class ReviewApiController {
    private final ReviewService reviewService;

    @Operation(summary = "Review Save Test", description = "리뷰 저장")
    @PostMapping
    public ResponseEntity<CommonResponse> reviewSave(HttpServletRequest request, @RequestBody @Validated ReviewSaveRequestDto dto){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(reviewService.reviewSave(id, dto)), HttpStatus.OK);
    }

    @Operation(summary = "Review Delete Test", description = "리뷰 삭제")
    @DeleteMapping("/{reviewid}")
    public ResponseEntity<CommonResponse> reviewDelete(HttpServletRequest request, @PathVariable("reviewid") Long reviewid){
        String id = (String) request.getAttribute("id");
        reviewService.reviewDelete(id, reviewid);
        return null;
    }

    @Operation(summary = "Counselor Review View Test", description = "해당 상담사한테 달린 리뷰 조회")
    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> reviewCounselorView(@PathVariable("id") String id){
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(reviewService.reviewCounselorView(id)), HttpStatus.OK);
    }
}
