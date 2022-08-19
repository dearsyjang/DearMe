package com.dearme.demo.domain.counselingdocument.exception;

public class CounselorCreateCounselingException extends RuntimeException{
    public CounselorCreateCounselingException() {
        super("상담사는 상담예약을 신청 할 수 없습니다.");
    }
}
