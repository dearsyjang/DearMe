package com.dearme.demo.domain.review.exception;

public class NoReviewDeletePermissionException extends RuntimeException{
    public NoReviewDeletePermissionException() {
        super("평가 삭제 권한이 없습니다.");
    }
}
