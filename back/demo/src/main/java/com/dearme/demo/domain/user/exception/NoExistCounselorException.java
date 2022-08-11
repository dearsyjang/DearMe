package com.dearme.demo.domain.user.exception;

public class NoExistCounselorException extends RuntimeException{
    public NoExistCounselorException() {
        super("존재하지 않는 상담사입니다.");
    }
}
