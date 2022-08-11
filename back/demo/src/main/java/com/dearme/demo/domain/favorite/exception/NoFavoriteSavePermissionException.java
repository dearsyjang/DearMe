package com.dearme.demo.domain.favorite.exception;

public class NoFavoriteSavePermissionException extends RuntimeException{
    public NoFavoriteSavePermissionException() {
        super("상담사는 즐겨찾기 기능을 사용할 수 없습니다.");
    }
}
