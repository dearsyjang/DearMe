package com.dearme.demo.domain.videodiary.repository;

import com.dearme.demo.domain.videodiary.entity.VideoDiary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoDiaryRepository extends JpaRepository<VideoDiary, Long> {
}
