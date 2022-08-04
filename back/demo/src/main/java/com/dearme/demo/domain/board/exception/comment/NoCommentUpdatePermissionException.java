package com.dearme.demo.domain.board.exception.comment;

public class NoCommentUpdatePermissionException extends RuntimeException{
    public NoCommentUpdatePermissionException() {
        super("댓글 수정 권한이 없습니다.");
    }
}
