package com.dearme.demo.domain.counseling.controller;

import com.dearme.demo.domain.counseling.dto.UpdateCounselingRequestDto;
import com.dearme.demo.domain.counseling.service.CounselingServiceImpl;
import com.dearme.demo.global.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/counselings")
@RequiredArgsConstructor
public class CounselingController {
    private final CounselingServiceImpl counselingService;

    @GetMapping
    public ResponseEntity<CommonResponse> getCounselings(HttpServletRequest request){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(counselingService.getCounselings(id)), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CommonResponse> updateCounseling(HttpServletRequest request,@RequestBody UpdateCounselingRequestDto dto){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(counselingService.updateCounseling(id, dto)), HttpStatus.OK);
    }
}
