package com.dearme.demo.domain.board.dto.comment;

import com.dearme.demo.domain.board.entity.Comment;
import lombok.Data;

import java.util.Date;


@Data
public class CommentSaveRequestDto {

    private String contents;
    private Date date;


    public Comment toCommentEntity(){
        return Comment.builder()
                .contents(this.contents)
                .date(this.date)
                .build();
    }
}
