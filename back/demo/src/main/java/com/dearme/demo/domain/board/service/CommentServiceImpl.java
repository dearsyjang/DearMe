package com.dearme.demo.domain.board.service;

import com.dearme.demo.domain.board.dto.CommentSaveRequestDto;
import com.dearme.demo.domain.board.dto.CommentUpdateRequestDto;
import com.dearme.demo.domain.board.entity.Comment;
import com.dearme.demo.domain.board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public Comment commentSave(CommentSaveRequestDto dto){
        Comment comment;
        comment=dto.toCommentEntity();
        commentRepository.save(comment);
        return comment;
    }

    @Transactional
    public Long updateComment(Long commentid, CommentUpdateRequestDto dto) {
        Comment comment = commentRepository.findCommentByCommentid(commentid);
        comment.update(dto.getContents(), dto.getDate());
        return commentid;
    }

    @Transactional
    public void deleteComment(Long commentid) {
        Comment comment = commentRepository.findCommentByCommentid(commentid);
        commentRepository.delete(comment);
    }

}
