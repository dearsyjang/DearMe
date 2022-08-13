package com.dearme.demo.domain.board.dto.comment;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class CommentUpdateRequestDto {
    @NotBlank(message = "contents는 비워둘 수 없습니다.")
    private String contents;


}
