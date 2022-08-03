package com.dearme.demo.domain.board.exception.board;

public class NoBoardSavePermissionException extends RuntimeException{
    public NoBoardSavePermissionException() {
        super("상담사는 게시글을 작성할 수 없습니다.");
    }
}
