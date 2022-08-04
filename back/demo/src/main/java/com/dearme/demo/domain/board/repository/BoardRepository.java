package com.dearme.demo.domain.board.repository;

import com.dearme.demo.domain.board.dto.board.BoardsViewResponseDto;
import com.dearme.demo.domain.board.entity.Board;
import com.dearme.demo.domain.board.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<Board> findBoardByBoardid(Long boardid);


}
