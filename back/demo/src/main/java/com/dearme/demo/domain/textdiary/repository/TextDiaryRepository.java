package com.dearme.demo.domain.textdiary.repository;

import com.dearme.demo.domain.textdiary.entity.TextDiary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TextDiaryRepository extends JpaRepository<TextDiary, Long> {
    List<TextDiary> findAllByUser_IdAndYearAndMonth(String id, Integer year, Integer month);
    void deleteByUser_IdAndId(String id, Long textDiaryId);
    boolean existsTextDiaryByUser_IdAndYearAndMonthAndDay(String id, Integer year, Integer month, Integer day);
}
