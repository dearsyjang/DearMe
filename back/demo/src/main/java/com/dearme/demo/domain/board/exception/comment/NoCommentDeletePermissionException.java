package com.dearme.demo.domain.board.exception.comment;

public class NoCommentDeletePermissionException extends RuntimeException{
    public NoCommentDeletePermissionException() {
        super("댓글 삭제 권한이 없습니다.");
    }
}
