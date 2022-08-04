package com.dearme.demo.domain.textdiary.controller;

import com.dearme.demo.domain.textdiary.dto.PostTextDiaryRequestDto;
import com.dearme.demo.domain.textdiary.service.TextDiaryService;
import com.dearme.demo.global.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
