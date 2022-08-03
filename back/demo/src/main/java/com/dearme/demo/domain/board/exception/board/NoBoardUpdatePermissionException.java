package com.dearme.demo.domain.board.exception.board;

public class NoBoardUpdatePermissionException extends RuntimeException{
    public NoBoardUpdatePermissionException() {
        super("게시글 수정 권한이 없습니다.");
    }
}
