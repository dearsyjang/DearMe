package com.dearme.demo.domain.group.exception;

public class GroupDeleteException extends RuntimeException{
    public GroupDeleteException() {
        super("그룹 삭제 권한이 없습니다.");
    }
}
