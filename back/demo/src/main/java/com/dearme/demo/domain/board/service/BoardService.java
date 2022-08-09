package com.dearme.demo.domain.board.service;

import com.dearme.demo.domain.board.dto.board.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface BoardService {

    BoardSaveResponseDto boardSave(String id, BoardSaveRequestDto dto);
    Page<BoardsViewResponseDto> getBoards(PageRequest pageRequest);
    BoardViewResponseDto getBoard(Long boardId);

    BoardUpdateResponseDto updateBoard(String id, Long boardId, BoardUpdateRequestDto dto);
    void deleteBoard(String id, Long boardId);
}
