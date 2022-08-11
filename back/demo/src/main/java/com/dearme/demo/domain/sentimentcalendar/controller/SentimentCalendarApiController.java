package com.dearme.demo.domain.sentimentcalendar.controller;

import com.dearme.demo.domain.sentimentcalendar.service.SentimentCalendarService;
import com.dearme.demo.global.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RequestMapping("/sentiment-calendar")
@RestController
public class SentimentCalendarApiController {
    private final SentimentCalendarService sentimentCalendarService;

    @GetMapping("/{year}/{month}")
    public ResponseEntity<CommonResponse> getSentiments(HttpServletRequest request, @PathVariable("year") Integer year, @PathVariable("month") Integer month){
        String id = (String) request.getAttribute("id");
        return new ResponseEntity<>(CommonResponse.getSuccessResponse(sentimentCalendarService.getSentiments(id, year, month)), HttpStatus.OK);
    }

}
