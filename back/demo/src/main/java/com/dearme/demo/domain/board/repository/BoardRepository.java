package com.dearme.demo.domain.board.repository;

import com.dearme.demo.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findBoardByBoardid(Long boardid);


}
