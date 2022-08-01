package com.dearme.demo.domain.board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {
    private String title;
    private String contents;
    private Date date;

    @Builder
    public BoardUpdateRequestDto(String title, String contents, Date date) {
        this.title = title;
        this.contents = contents;
        this.date = date;
    }
}
