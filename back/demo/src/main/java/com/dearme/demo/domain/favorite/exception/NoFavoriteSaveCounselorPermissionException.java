package com.dearme.demo.domain.favorite.exception;

public class NoFavoriteSaveCounselorPermissionException extends RuntimeException{
    public NoFavoriteSaveCounselorPermissionException() {
        super("해당 유저는 상담사가 아닙니다.");
    }
}
