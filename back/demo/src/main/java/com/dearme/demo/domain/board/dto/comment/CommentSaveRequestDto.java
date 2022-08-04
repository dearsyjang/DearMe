package com.dearme.demo.domain.board.dto.comment;

import com.dearme.demo.domain.board.entity.Comment;
import lombok.Data;

import java.util.Date;


@Data
public class CommentSaveRequestDto {

    private Date date;
    private String contents;


    public Comment toCommentEntity(){
        return Comment.builder()
                .date(this.date)
                .contents(this.contents)
                .build();
    }
}
