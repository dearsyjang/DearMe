package com.dearme.demo.domain.board.service;

import com.dearme.demo.domain.board.dto.BoardResponseDto;
import com.dearme.demo.domain.board.dto.BoardSaveRequestDto;
import com.dearme.demo.domain.board.dto.BoardUpdateRequestDto;
import com.dearme.demo.domain.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface BoardService {

    Board boardSave(BoardSaveRequestDto dto);
    Page<Board> getBoards(PageRequest pageRequest);
    BoardResponseDto getBoard(Long boardid);

    Long updateBoard(Long boardid, BoardUpdateRequestDto dto);
    void deleteBoard(Long boardid);
}
