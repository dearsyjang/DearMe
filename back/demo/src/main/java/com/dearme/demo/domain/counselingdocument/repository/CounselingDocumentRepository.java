package com.dearme.demo.domain.counselingdocument.repository;

import com.dearme.demo.domain.counselingdocument.entity.CounselingDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CounselingDocumentRepository extends JpaRepository<CounselingDocument, Long> {
    void deleteCounselingDocumentByUser_IdAndId(String userId, Long id);

    Optional<CounselingDocument> findById(Long id);

    Optional<CounselingDocument> findTop1ByCounselor_IdAndUser_UserIdOrderByYearDescMonthDescHoursDesc(String counselorId, Long userId);

    boolean existsCounselingDocumentByUser_IdAndCounselor_UserIdAndYearAndMonthAndDayAndHours(String id, Long counselorId, Integer year, Integer month, Integer day, Integer hours);
    boolean existsCounselingDocumentByUser_IdAndGroup_Id(String id, Long groupId);
}
