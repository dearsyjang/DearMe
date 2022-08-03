package com.dearme.demo.domain.user.repository;

import com.dearme.demo.domain.user.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerRepository extends JpaRepository<Career, Long> {
}
