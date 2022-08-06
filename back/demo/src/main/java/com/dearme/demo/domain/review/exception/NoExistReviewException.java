package com.dearme.demo.domain.review.exception;

public class NoExistReviewException extends RuntimeException{
    public NoExistReviewException() {
        super("존재하지 않는 평가입니다.");
    }
}
