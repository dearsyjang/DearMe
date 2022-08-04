package com.dearme.demo.domain.board.service;

import com.dearme.demo.domain.board.dto.board.*;
import com.dearme.demo.domain.board.entity.Board;
import com.dearme.demo.domain.board.entity.Comment;
import com.dearme.demo.domain.board.exception.board.NoExistBoardException;
import com.dearme.demo.domain.board.repository.BoardRepository;
import com.dearme.demo.domain.board.repository.CommentRepository;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistUserException;
import com.dearme.demo.domain.user.repository.UserRepository;
import com.dearme.demo.global.util.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public BoardSaveResponseDto boardSave(String id, BoardSaveRequestDto dto){

        Board board;
        board = dto.toBoardEntity();
//        User user = userRepository.findUserById(id).orElseThrow(() -> {
//            throw new NoExistUserException();
//        });
//        if(user.getType().equals("USER")){
//            board.setUser(user);
//            board.setNickname(user);
        boardRepository.save(board);
        return new BoardSaveResponseDto(board.getBoardid());
//        }else{
//            throw new NoBoardSavePermissionException();
//        }
    }
    @Override
    public Page<BoardsViewResponseDto> getBoards(PageRequest pageRequest){
        return boardRepository.findAll(pageRequest).map(m -> new BoardsViewResponseDto());
    }
    @Transactional
    public BoardViewResponseDto getBoard(Long boardid){
        Board board= boardRepository.findBoardByBoardid(boardid).orElseThrow(()->{
            throw new NoExistBoardException();
        });
        board.updateHitCnt();

        List<Comment> comment = board.getComments();
        return new BoardViewResponseDto(board.getBoardid(),
                board.getNickname(),
                board.getTitle(),
                board.getContents(),
                board.getHitcnt(),
                board.getDate(),
                comment);
    }

    @Transactional
    public BoardUpdateResponseDto updateBoard(String id, Long boardid, BoardUpdateRequestDto dto) {


        Board board = boardRepository.findBoardByBoardid(boardid).orElseThrow(()->{
            throw new NoExistBoardException();
        });
//        User user = userRepository.findUserById(id).orElseThrow(() -> {
//            throw new NoExistUserException();
//        });
//        if(user.getUserId().equals(board.getUser().getUserId())){
        board.update(dto.getTitle(), dto.getContents(), dto.getDate());
        return new BoardUpdateResponseDto(board.getBoardid());
//        }else{
//            throw new NoBoardUpdatePermissionException();
//        }
    }

    @Transactional
    public void deleteBoard(String id, Long boardid) {
        Board board = boardRepository.findBoardByBoardid(boardid).orElseThrow(()->{
            throw new NoExistBoardException();
        });
//        User user = userRepository.findUserById(id).orElseThrow(() -> {
//            throw new NoExistUserException();
//        });
//        if(user.getUserId().equals(board.getUser().getUserId())){
        boardRepository.delete(board);
//        }else{
//            throw new NoBoardDeletePermissionException();
//        }
    }


}
