package com.dearme.demo.domain.counselingdocument.exception;

public class NoExistDocumentException extends RuntimeException{
    public NoExistDocumentException() {
        super("상담 신청서가 존재하지 않습니다.");
    }
}
