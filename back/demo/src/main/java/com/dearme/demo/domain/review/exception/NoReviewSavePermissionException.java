package com.dearme.demo.domain.review.exception;

public class NoReviewSavePermissionException extends RuntimeException{
    public NoReviewSavePermissionException() {
        super("상담사는 평가를 할 수 없습니다.");
    }
}
