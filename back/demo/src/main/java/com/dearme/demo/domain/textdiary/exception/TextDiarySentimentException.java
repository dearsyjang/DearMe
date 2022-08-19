package com.dearme.demo.domain.textdiary.exception;

public class TextDiarySentimentException extends RuntimeException{
    public TextDiarySentimentException() {
        super("텍스트 일기 감정 분석을 실패하였습니다.");
    }
}
