package com.dearme.demo.domain.counselingroom.exception;

public class CounselingRoomNotCreatedYet extends RuntimeException{
    public CounselingRoomNotCreatedYet() {
        super("상담방이 생성되지 않았습니다.");
    }
}
