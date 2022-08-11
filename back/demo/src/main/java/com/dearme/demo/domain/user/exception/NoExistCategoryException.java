package com.dearme.demo.domain.user.exception;

public class NoExistCategoryException extends RuntimeException{
    public NoExistCategoryException() {
        super("존재하지 않는 카테고리 입니다.");
    }
}
