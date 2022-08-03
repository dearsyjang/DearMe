package com.dearme.demo.domain.board.service;

import com.dearme.demo.domain.board.dto.BoardResponseDto;
import com.dearme.demo.domain.board.dto.BoardSaveRequestDto;
import com.dearme.demo.domain.board.dto.BoardUpdateRequestDto;
import com.dearme.demo.domain.board.entity.Board;
import com.dearme.demo.domain.board.entity.Comment;
import com.dearme.demo.domain.board.repository.BoardRepository;
import com.dearme.demo.domain.board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    @Override
    @Transactional
    public Board boardSave(BoardSaveRequestDto dto){
        Board board;
        board = dto.toBoardEntity();
        boardRepository.save(board);
        return board;
    }
    @Override
    public Page<Board> getBoards(PageRequest pageRequest){
        return boardRepository.findAll(pageRequest);
    }
    @Transactional
    public BoardResponseDto getBoard(Long boardid){
        Board board= boardRepository.findBoardByBoardid(boardid);
        board.updateHitCnt();
        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setUserid(board.getUserid());
        boardResponseDto.setTitle(board.getTitle());
        boardResponseDto.setContents(board.getContents());
        boardResponseDto.setHitCnt(board.getHitCnt());
        boardResponseDto.setDate(board.getDate());

        List<Comment> comment = commentRepository.findCommentByBoardid(boardid);
        boardResponseDto.setComment(comment);
        return boardResponseDto;
    }

    @Transactional
    public Long updateBoard(Long boardid, BoardUpdateRequestDto dto) {
        Board board = boardRepository.findBoardByBoardid(boardid);
        board.update(dto.getTitle(), dto.getContents(), dto.getDate());
        return boardid;
    }

    @Transactional
    public void deleteBoard(Long boardid) {
        Board board = boardRepository.findBoardByBoardid(boardid);
        boardRepository.delete(board);
    }


}
