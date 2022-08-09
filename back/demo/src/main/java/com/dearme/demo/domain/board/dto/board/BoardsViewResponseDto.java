package com.dearme.demo.domain.board.dto.board;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class BoardsViewResponseDto {
    private Long id;

    private String nickName;

    private String title;


    private int hitCnt;

    private LocalDateTime date;


}
