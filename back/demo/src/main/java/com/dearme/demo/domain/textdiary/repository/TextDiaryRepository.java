package com.dearme.demo.domain.textdiary.repository;

import com.dearme.demo.domain.textdiary.entity.TextDiary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TextDiaryRepository extends JpaRepository<TextDiary, Long> {
    List<TextDiary> findAllByUser_IdAndMonth(String id, Integer month);
}
