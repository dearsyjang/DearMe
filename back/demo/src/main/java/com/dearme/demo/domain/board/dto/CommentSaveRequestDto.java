package com.dearme.demo.domain.board.dto;

import com.dearme.demo.domain.board.entity.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;


@Getter
@NoArgsConstructor
public class CommentSaveRequestDto {

    private Long boardid;
    private String counselorid;
    private Date date;
    private String contents;

    public CommentSaveRequestDto(Long boardid, String counselorid, Date date, String contents) {
        this.boardid = boardid;
        this.counselorid = counselorid;
        this.date = date;
        this.contents = contents;
    }

    @Builder
    public Comment toCommentEntity(){
        return Comment.builder()
                .boardid(this.boardid)
                .counselorid(this.counselorid)
                .date(this.date)
                .contents(this.contents)
                .build();
    }
}
