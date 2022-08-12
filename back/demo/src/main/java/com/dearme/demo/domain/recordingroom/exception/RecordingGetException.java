package com.dearme.demo.domain.recordingroom.exception;

public class RecordingGetException extends RuntimeException{
    public RecordingGetException() {
        super("영상 일기를 불러올 수 없습니다.");
    }
}
