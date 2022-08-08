package com.dearme.demo.domain.user.repository;

import com.dearme.demo.domain.user.entity.CounselorProfile;
import com.dearme.demo.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounselorProfileRepository extends JpaRepository<CounselorProfile, Long> {
    CounselorProfile findCounselorProfileByCounselor_Id(String id);
}
