package com.dearme.demo.domain.textdiary.controller;

import com.dearme.demo.domain.textdiary.dto.PostTextDiaryRequestDto;
import com.dearme.demo.domain.textdiary.service.TextDiaryService;
import com.dearme.demo.global.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/text-diaries")
@RequiredArgsConstructor
public class TextDiaryController {
    private final TextDiaryService textDiaryService;

    @PostMapping
    public ResponseEntity<CommonResponse> postDiary(HttpServletRequest request, @RequestBody PostTextDiaryRequestDto dto){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(textDiaryService.postTextDiary(id, dto)), HttpStatus.OK);
    }

    @GetMapping("/{textDiaryId}")
    public ResponseEntity<CommonResponse> getDetails(HttpServletRequest request, @PathVariable Long textDiaryId){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(textDiaryService.getDetails(id, textDiaryId)), HttpStatus.OK);
    }

    @GetMapping("/month/{month}")
    public ResponseEntity<CommonResponse> getList(HttpServletRequest request, @PathVariable("month") Integer month){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(textDiaryService.getList(id, month)), HttpStatus.OK);
    }
}
