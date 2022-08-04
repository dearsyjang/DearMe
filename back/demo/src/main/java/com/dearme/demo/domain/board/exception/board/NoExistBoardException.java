package com.dearme.demo.domain.board.exception.board;

public class NoExistBoardException extends RuntimeException{
    public NoExistBoardException() {
        super("존재하지 않는 게시글입니다.");
    }
}
