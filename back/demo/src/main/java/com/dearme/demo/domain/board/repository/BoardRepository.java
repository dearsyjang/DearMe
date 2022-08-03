package com.dearme.demo.domain.board.repository;

import com.dearme.demo.domain.board.entity.Board;
import com.dearme.demo.domain.board.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findBoardByBoardid(Long boardid);


}
