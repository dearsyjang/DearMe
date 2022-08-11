package com.dearme.demo.domain.board.dto.comment;

import com.dearme.demo.domain.board.entity.Comment;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;


@Data
public class CommentSaveRequestDto {

    private String contents;


    public Comment toCommentEntity(){
        return Comment.builder()
                .contents(this.contents)
                .date(LocalDateTime.now())
                .build();
    }
}
