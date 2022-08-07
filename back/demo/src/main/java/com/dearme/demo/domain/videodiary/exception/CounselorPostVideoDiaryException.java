package com.dearme.demo.domain.videodiary.exception;

public class CounselorPostVideoDiaryException extends RuntimeException{
    public CounselorPostVideoDiaryException() {
        super("상담사는 영상 일기를 생성할 수 없습니다.");
    }
}
