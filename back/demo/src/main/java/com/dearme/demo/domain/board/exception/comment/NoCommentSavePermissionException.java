package com.dearme.demo.domain.board.exception.comment;

public class NoCommentSavePermissionException extends RuntimeException{
    public NoCommentSavePermissionException() {
        super("상담사 이외에는 댓글을 작성할 수 없습니다.");
    }
}
