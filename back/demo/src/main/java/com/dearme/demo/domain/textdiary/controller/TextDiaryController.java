package com.dearme.demo.domain.textdiary.controller;

import com.dearme.demo.domain.textdiary.service.TextDiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/text-diaries")
@RequiredArgsConstructor
public class TextDiaryController {
    private final TextDiaryService textDiaryService;
}
