package com.dearme.demo.domain.favorite.exception;

public class NoFavoriteDeletePermissionException extends RuntimeException{
    public NoFavoriteDeletePermissionException() {
        super("즐겨찾기 삭제 권한이 없습니다.");
    }
}
