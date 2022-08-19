package com.dearme.demo.domain.user.exception;

public class CounselorNotExistPictureException extends RuntimeException{
    public CounselorNotExistPictureException() {
        super("상담사는 사진이 반드시 존재해야합니다.");
    }
}
