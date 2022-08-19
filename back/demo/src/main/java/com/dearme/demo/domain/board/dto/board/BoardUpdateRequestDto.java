package com.dearme.demo.domain.board.dto.board;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

@Data
public class BoardUpdateRequestDto {
    @NotBlank(message = "title은 비워둘 수 없습니다.")
    private String title;
    @NotBlank(message = "contents는 비워둘 수 없습니다.")
    private String contents;

}
