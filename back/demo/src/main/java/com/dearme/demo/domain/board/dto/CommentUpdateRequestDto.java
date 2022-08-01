package com.dearme.demo.domain.board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class CommentUpdateRequestDto {
    private String contents;
    private Date date;

    @Builder
    public CommentUpdateRequestDto(String contents, Date date) {
        this.contents = contents;
        this.date=date;
    }
}
