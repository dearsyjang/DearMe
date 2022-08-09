package com.dearme.demo.domain.videodiary.exception;

public class NoPermissionVideoDiaryException extends RuntimeException{
    public NoPermissionVideoDiaryException() {
        super("영상 일기에 접근 권한이 없습니다.");
    }
}
