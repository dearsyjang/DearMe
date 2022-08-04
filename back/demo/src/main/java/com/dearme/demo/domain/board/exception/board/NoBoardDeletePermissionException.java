package com.dearme.demo.domain.board.exception.board;

public class NoBoardDeletePermissionException extends RuntimeException{
    public NoBoardDeletePermissionException() {
        super("게시글 삭제 권한이 없습니다.");
    }
}
