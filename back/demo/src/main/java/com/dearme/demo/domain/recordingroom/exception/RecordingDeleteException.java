package com.dearme.demo.domain.recordingroom.exception;

public class RecordingDeleteException extends RuntimeException{
    public RecordingDeleteException() {
        super("영상 일기를 삭제할 수 없습니다.");
    }
}
