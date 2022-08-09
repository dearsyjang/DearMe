package com.dearme.demo.domain.user.repository;

import com.dearme.demo.domain.user.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CareerRepository extends JpaRepository<Career, Long> {
    Optional<Career> findCareerByCounselorProfile_Counselor_IdAndId(String id, Long CounselId);
    void deleteCareerByCounselorProfile_Counselor_IdAndId(String counselorId, Long id);
}
