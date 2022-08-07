package com.dearme.demo.domain.textdiary.exception;

public class NoPermissionTextDiaryException extends RuntimeException{
    public NoPermissionTextDiaryException() {
        super("텍스트 일기에 접근 권한이 없습니다.");
    }
}
