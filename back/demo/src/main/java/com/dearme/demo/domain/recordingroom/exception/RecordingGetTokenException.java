package com.dearme.demo.domain.recordingroom.exception;

public class RecordingGetTokenException extends RuntimeException{
    public RecordingGetTokenException() {
        super("세션 정보를 받아오지 못했습니다.");
    }
}
