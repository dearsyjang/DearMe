package com.dearme.demo.domain.user.repository;

import com.dearme.demo.domain.user.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}
