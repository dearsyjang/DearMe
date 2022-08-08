package com.dearme.demo.domain.board.service;

import com.dearme.demo.domain.board.dto.comment.CommentSaveRequestDto;
import com.dearme.demo.domain.board.dto.comment.CommentSaveResponseDto;
import com.dearme.demo.domain.board.dto.comment.CommentUpdateRequestDto;
import com.dearme.demo.domain.board.dto.comment.CommentUpdateResponseDto;
import com.dearme.demo.domain.board.entity.Board;
import com.dearme.demo.domain.board.entity.Comment;
import com.dearme.demo.domain.board.exception.board.NoExistBoardException;
import com.dearme.demo.domain.board.exception.comment.NoCommentDeletePermissionException;
import com.dearme.demo.domain.board.exception.comment.NoCommentSavePermissionException;
import com.dearme.demo.domain.board.exception.comment.NoCommentUpdatePermissionException;
import com.dearme.demo.domain.board.exception.comment.NoExistCommentException;
import com.dearme.demo.domain.board.repository.BoardRepository;
import com.dearme.demo.domain.board.repository.CommentRepository;
import com.dearme.demo.domain.user.entity.Type;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistCounselorException;
import com.dearme.demo.domain.user.exception.NoExistUserException;
import com.dearme.demo.domain.user.repository.UserRepository;
import com.dearme.demo.global.util.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public CommentSaveResponseDto commentSave(String id, Long boardId, CommentSaveRequestDto dto){
        Comment comment;
        comment=dto.toCommentEntity();
        Board board = boardRepository.findBoardById(boardId).orElseThrow(()->{
            throw new NoExistBoardException();
        });
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistCounselorException();
        });
        if(user.getType().equals(Type.COUNSELOR)){
            comment.setBoard(board);
            comment.setUser(user);
            commentRepository.save(comment);
            return new CommentSaveResponseDto(comment.getId());
        }else{
            throw new NoCommentSavePermissionException();
        }

    }

    @Transactional
    public CommentUpdateResponseDto updateComment(String id, Long commentId, CommentUpdateRequestDto dto) {
        Comment comment = commentRepository.findCommentById(commentId).orElseThrow(()->{
            throw new NoExistCommentException();
        });
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistCounselorException();
        });
        if(user.getUserId().equals(comment.getUser().getUserId())){
            comment.update(dto.getDate(), dto.getContents());
            return new CommentUpdateResponseDto(comment.getId());
        }else{
            throw new NoCommentUpdatePermissionException();
        }
    }

    @Transactional
    public void deleteComment(String id, Long commentId) {
        Comment comment = commentRepository.findCommentById(commentId).orElseThrow(()->{
            throw new NoExistCommentException();
        });
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistCounselorException();
        });
        if(user.getUserId().equals(comment.getUser().getUserId())){
            commentRepository.delete(comment);
        }else{
            throw new NoCommentDeletePermissionException();
        }
    }

}
