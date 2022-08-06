package com.dearme.demo.domain.counseling.repository;

import com.dearme.demo.domain.counseling.entity.Counseling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CounselingRepository extends JpaRepository<Counseling, Long> {
    List<Counseling> findAllByCounselor_Id(String counselorId);
}
