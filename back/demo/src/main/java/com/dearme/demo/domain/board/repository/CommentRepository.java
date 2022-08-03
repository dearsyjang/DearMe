package com.dearme.demo.domain.board.repository;

import com.dearme.demo.domain.board.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findCommentByCommentid(Long commentid);
}
