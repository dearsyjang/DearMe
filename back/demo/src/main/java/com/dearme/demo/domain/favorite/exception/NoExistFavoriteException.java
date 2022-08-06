package com.dearme.demo.domain.favorite.exception;

public class NoExistFavoriteException extends RuntimeException{
    public NoExistFavoriteException() {
        super("즐겨찾기가 없습니다.");
    }
}
