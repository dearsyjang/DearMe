package com.dearme.demo.domain.board.dto.board;

import com.dearme.demo.domain.board.entity.Board;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;


@Data
public class BoardSaveRequestDto {
    @NotBlank(message = "title은 비워둘 수 없습니다.")
    private String title;
    @NotBlank(message = "contents는 비워둘 수 없습니다.")
    private String contents;

    public Board toBoardEntity(){
        Date date = new Date();
        return Board.builder()
                .title(this.title)
                .contents(this.contents)
                .date(LocalDateTime.now())
                .build();
    }
}
