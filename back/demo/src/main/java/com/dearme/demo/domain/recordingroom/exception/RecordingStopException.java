package com.dearme.demo.domain.recordingroom.exception;

public class RecordingStopException extends RuntimeException{
    public RecordingStopException() {
        super("영상 일기를 정지할 수 없습니다.");
    }
}
