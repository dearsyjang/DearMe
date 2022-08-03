package com.dearme.demo.domain.board.service;

import com.dearme.demo.domain.board.dto.board.*;
import com.dearme.demo.domain.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface BoardService {

    BoardSaveResponseDto boardSave(String id, BoardSaveRequestDto dto);
    Page<Board> getBoards(PageRequest pageRequest);
    BoardViewResponseDto getBoard(Long boardid);

    BoardUpdateResponseDto updateBoard(String id, Long boardid, BoardUpdateRequestDto dto);
    void deleteBoard(String id, Long boardid);
}
