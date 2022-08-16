package com.dearme.demo.domain.textdiary.exception;

public class AlreadyExistTextDiaryException extends RuntimeException{
    public AlreadyExistTextDiaryException() {
        super("해당 날짜에 이미 텍스트 일기가 존재합니다.");
    }
}
