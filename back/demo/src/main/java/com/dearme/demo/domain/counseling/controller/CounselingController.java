package com.dearme.demo.domain.counseling.controller;

import com.dearme.demo.domain.counseling.service.CounselingServiceImpl;
import com.dearme.demo.global.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
