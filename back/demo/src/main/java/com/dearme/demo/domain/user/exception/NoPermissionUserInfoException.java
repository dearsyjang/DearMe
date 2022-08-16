package com.dearme.demo.domain.user.exception;

public class NoPermissionUserInfoException extends RuntimeException{
    public NoPermissionUserInfoException() {
        super("사용자 정보에 접근 권한이 없습니다.");
    }
}
