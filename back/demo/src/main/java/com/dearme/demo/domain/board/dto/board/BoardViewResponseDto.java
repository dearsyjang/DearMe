package com.dearme.demo.domain.board.dto.board;

import com.dearme.demo.domain.board.dto.comment.CommentResponseDto;
import com.dearme.demo.domain.board.entity.Board;
import com.dearme.demo.domain.board.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class BoardViewResponseDto {
    private Long id;
    private Long userId;
    private String nickName;
    private String title;

    private String contents;

    private int hitCnt;

    private LocalDateTime date;

    private List<CommentResponseDto> comments;

    public static BoardViewResponseDto of(Board b, List<CommentResponseDto> c){
        return BoardViewResponseDto.builder()
                .id(b.getId())
                .userId(b.getUser().getUserId())
                .nickName(b.getUser().getNickName())
                .title(b.getTitle())
                .contents(b.getContents())
                .hitCnt(b.getHitCnt())
                .date(b.getDate())
                .comments(c)
                .build();
    }

}
