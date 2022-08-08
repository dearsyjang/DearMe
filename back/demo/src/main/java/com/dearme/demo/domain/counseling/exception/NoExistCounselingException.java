package com.dearme.demo.domain.counseling.exception;

public class NoExistCounselingException extends RuntimeException{
    public NoExistCounselingException() {
        super("해당 상담은 존재하지 않습니다.");
    }
}
