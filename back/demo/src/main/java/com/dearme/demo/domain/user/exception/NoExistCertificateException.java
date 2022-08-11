package com.dearme.demo.domain.user.exception;

public class NoExistCertificateException extends RuntimeException{
    public NoExistCertificateException() {
        super("존재하지 않는 자격증 입니다.");
    }
}
