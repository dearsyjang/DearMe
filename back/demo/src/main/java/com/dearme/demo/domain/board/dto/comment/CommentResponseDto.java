package com.dearme.demo.domain.board.dto.comment;

import com.dearme.demo.domain.board.entity.Board;
import com.dearme.demo.domain.board.entity.Comment;
import com.dearme.demo.domain.group.dto.GroupInfoResponseDto;
import com.dearme.demo.domain.group.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
public class CommentResponseDto {
    private Long id;
    private Long userId;
    private String nickName;
    private LocalDateTime date;
    private String contents;

    public static CommentResponseDto of(Comment c){
        return CommentResponseDto.builder()
                .id(c.getId())
                .userId(c.getUser().getUserId())
                .nickName(c.getUser().getNickName())
                .date(c.getDate())
                .contents(c.getContents())
                .build();
    }

}
