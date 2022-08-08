package com.dearme.demo.domain.videodiary.repository;

import com.dearme.demo.domain.textdiary.entity.TextDiary;
import com.dearme.demo.domain.videodiary.entity.VideoDiary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoDiaryRepository extends JpaRepository<VideoDiary, Long> {
    VideoDiary findVideoDiaryById(Long id);
    List<VideoDiary> findAllByUser_IdAndYearAndMonth(String id, Integer year, Integer month);
    void deleteByUser_IdAndId(String id, Long videoDiaryId);

}
