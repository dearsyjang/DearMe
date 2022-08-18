package com.dearme.demo.domain.counselingdocument.exception;

public class AlreadyExistCounselorDocumentException extends RuntimeException{
    public AlreadyExistCounselorDocumentException() {
        super("해당 상담 신청서가 존재합니다.");
    }
}
