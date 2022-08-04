package com.dearme.demo.domain.board.exception.comment;

public class NoExistCommentException extends RuntimeException{
    public NoExistCommentException() {
        super("존재하지 않는 댓글입니다.");
    }
}
