package com.dearme.demo.domain.board.dto.board;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class BoardUpdateRequestDto {
    private String title;
    private String contents;

}
