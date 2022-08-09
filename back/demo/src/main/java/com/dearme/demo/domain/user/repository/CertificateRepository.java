package com.dearme.demo.domain.user.repository;

import com.dearme.demo.domain.user.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    Optional<Certificate> findCertificateByCounselorProfile_Counselor_IdAndId(String id, Long certificateId);
    void deleteCertificateByCounselorProfile_Counselor_IdAndId(String counselorId, Long certificateId);
}
