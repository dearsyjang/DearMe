package com.dearme.demo.domain.videodiary.exception;

public class VideoDiarySentimentException extends RuntimeException{
    public VideoDiarySentimentException() {
        super("영상 일기 감정 분석을 실패하였습니다.");
    }
}
