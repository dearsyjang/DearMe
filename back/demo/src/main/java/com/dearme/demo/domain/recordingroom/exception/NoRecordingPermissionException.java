package com.dearme.demo.domain.recordingroom.exception;

public class NoRecordingPermissionException extends RuntimeException{
    public NoRecordingPermissionException() {
        super("상담사는 일기를 작성할 수 없습니다.");
    }
}
