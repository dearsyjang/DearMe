package com.dearme.demo.domain.videodiary.exception;

public class NoVideoDiaryException extends RuntimeException{
    public NoVideoDiaryException() {
        super("영상이 짧거나 없어서 기능을 이용하실 수 없습니다.");
    }
}
