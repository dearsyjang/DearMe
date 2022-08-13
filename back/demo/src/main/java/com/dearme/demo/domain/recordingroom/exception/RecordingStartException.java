package com.dearme.demo.domain.recordingroom.exception;

public class RecordingStartException extends RuntimeException{
    public RecordingStartException() {
        super("영상 일기를 시작할 수 없습니다.");
    }
}
