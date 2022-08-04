package com.dearme.demo.domain.board.service;

import com.dearme.demo.domain.board.dto.comment.CommentSaveRequestDto;
import com.dearme.demo.domain.board.dto.comment.CommentSaveResponseDto;
import com.dearme.demo.domain.board.dto.comment.CommentUpdateRequestDto;
import com.dearme.demo.domain.board.dto.comment.CommentUpdateResponseDto;
import com.dearme.demo.domain.board.entity.Board;
import com.dearme.demo.domain.board.entity.Comment;
import com.dearme.demo.domain.board.exception.board.NoExistBoardException;
import com.dearme.demo.domain.board.exception.comment.NoExistCommentException;
import com.dearme.demo.domain.board.repository.BoardRepository;
import com.dearme.demo.domain.board.repository.CommentRepository;
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
    public CommentSaveResponseDto commentSave(String id, Long boardid, CommentSaveRequestDto dto){
        Comment comment;
        comment=dto.toCommentEntity();
        Board board = boardRepository.findBoardByBoardid(boardid).orElseThrow(()->{
            throw new NoExistBoardException();
        });
        System.out.println(board);
        System.out.println(comment);
//        User user = userRepository.findUserById(id).orElseThrow(() -> {
//            throw new NoExistUserException();
//        });
//        if(user.getType().equals("COUNSELOR")){
        comment.setBoard(board);
//           comment.setUser(user);
            commentRepository.save(comment);
            return new CommentSaveResponseDto(comment.getCommentid());
//        }else{
//            throw new NoCommentSavePermissionException();
//        }

    }

    @Transactional
    public CommentUpdateResponseDto updateComment(String id, Long commentid, CommentUpdateRequestDto dto) {
        Comment comment = commentRepository.findCommentByCommentid(commentid).orElseThrow(()->{
            throw new NoExistCommentException();
        });
//        User user = userRepository.findUserById(id).orElseThrow(() -> {
//            throw new NoExistUserException();
//        });
//        if(user.getUserId().equals(comment.getUser().getUserId())){
            comment.update(dto.getContents(), dto.getDate());
            return new CommentUpdateResponseDto(comment.getCommentid());
//        }else{
//            throw new NoCommentUpdatePermissionException();
//        }
    }

    @Transactional
    public void deleteComment(String id, Long commentid) {
        Comment comment = commentRepository.findCommentByCommentid(commentid).orElseThrow(()->{
            throw new NoExistCommentException();
        });
//        User user = userRepository.findUserById(id).orElseThrow(() -> {
//            throw new NoExistUserException();
//        });
//        if(user.getUserId().equals(comment.getUser().getUserId())){
            commentRepository.delete(comment);
//        }else{
//            throw new NoCommentDeletePermissionException();
//        }
    }

}
