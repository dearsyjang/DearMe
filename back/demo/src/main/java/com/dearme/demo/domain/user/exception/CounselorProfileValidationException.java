package com.dearme.demo.domain.user.exception;

public class CounselorProfileValidationException extends RuntimeException{
    public CounselorProfileValidationException() {
        super("상담사는 반드시 경력, 카테고리, 자격증, 자기소개, 상담 가격이 존재해야 합니다");
    }
}
