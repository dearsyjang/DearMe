package com.dearme.demo.domain.videodiary.exception;

public class VideoDiaryRecordingException extends RuntimeException{
    public VideoDiaryRecordingException() {
        super("영상을 저장하지 못했습니다.");
    }
}
