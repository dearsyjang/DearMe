package com.dearme.demo.domain.group.exception;

public class UserCreateGroupException extends RuntimeException{
    public UserCreateGroupException() {
        super("상담사가 아니면 그룹을 생성할 수 없습니다.");
    }
}
