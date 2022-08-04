package com.dearme.demo.domain.textdiary.repository;

import com.dearme.demo.domain.textdiary.entity.TextDiary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextDiaryRepository extends JpaRepository<TextDiary, Long> {
}
