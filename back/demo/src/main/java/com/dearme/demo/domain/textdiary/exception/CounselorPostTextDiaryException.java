package com.dearme.demo.domain.textdiary.exception;

public class CounselorPostTextDiaryException extends RuntimeException{
    public CounselorPostTextDiaryException() {
        super("상담사는 텍스트 일기를 생성할 수 없습니다.");
    }
}
