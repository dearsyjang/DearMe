package com.dearme.demo.domain.user.exception;

public class NoExistCareerException extends RuntimeException{
    public NoExistCareerException() {
        super("존재하지 않는 경력입니다.");
    }
}
