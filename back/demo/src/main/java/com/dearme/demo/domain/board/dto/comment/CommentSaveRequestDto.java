package com.dearme.demo.domain.board.dto.comment;

import com.dearme.demo.domain.board.entity.Comment;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;


@Data
public class CommentSaveRequestDto {
    @NotBlank(message = "contents는 비워둘 수 없습니다.")
    private String contents;


    public Comment toCommentEntity(){
        return Comment.builder()
                .contents(this.contents)
                .date(LocalDateTime.now())
                .build();
    }
}
