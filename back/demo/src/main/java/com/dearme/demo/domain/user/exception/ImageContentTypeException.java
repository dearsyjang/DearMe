package com.dearme.demo.domain.user.exception;

public class ImageContentTypeException extends RuntimeException{
    public ImageContentTypeException() {
        super("이미지 파일만 가능합니다.");
    }
}
