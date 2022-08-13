package com.dearme.demo.domain.user.controller;

import com.dearme.demo.domain.user.dto.counselorsearch.CounselorSearchRequestDto;
import com.dearme.demo.domain.user.service.CounselorService;
import com.dearme.demo.global.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/counselors")
@RequiredArgsConstructor
public class CounselorController {
    private final CounselorService counselorService;
    @GetMapping
    public ResponseEntity<CommonResponse> getCounselors(HttpServletRequest request, CounselorSearchRequestDto dto){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(counselorService.getCounselors(id, dto)), HttpStatus.OK);
    }

    @GetMapping("/{counselorId}")
    public ResponseEntity<CommonResponse> getCounselor(HttpServletRequest request, @PathVariable("counselorId") Long counselorId){
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(counselorService.getCounselor(counselorId)), HttpStatus.OK);
    }
}
