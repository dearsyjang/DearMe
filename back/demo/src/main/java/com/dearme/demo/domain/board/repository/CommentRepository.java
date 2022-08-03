package com.dearme.demo.domain.board.repository;

import com.dearme.demo.domain.board.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findCommentByCommentid(Long commentid);
    List<Comment> findCommentByBoardid(Long boardid);
}
