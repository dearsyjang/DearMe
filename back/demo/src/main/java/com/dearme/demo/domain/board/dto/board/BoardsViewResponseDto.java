package com.dearme.demo.domain.board.dto.board;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardsViewResponseDto {
    private Long id;

    private String nickname;

    private String title;


    private int hitCnt;

    private String date;


}
