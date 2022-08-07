package com.dearme.demo.domain.group.exception;

public class GroupNotFoundExcetion extends RuntimeException{
    public GroupNotFoundExcetion() {
        super("해당 그룹이 존재하지 않습니다.");
    }
}
