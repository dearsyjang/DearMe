package com.dearme.demo.domain.counseling.repository;

import com.dearme.demo.domain.counseling.entity.Counseling;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CounselingRepository extends JpaRepository<Counseling, Long> {
    List<Counseling> findAllByCounselor_Id(String counselorId);
    List<Counseling> findAllByUser_Id(String userId);

    Optional<Counseling> findCounselingByCounselor_IdAndId(String counselorId, Long id);

    Optional<Counseling> findCounselingByUser_IdAndId(String userId, Long id);
}
