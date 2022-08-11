package com.dearme.demo.domain.user.repository;

import com.dearme.demo.domain.user.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findCategoryByCounselorProfile_Counselor_IdAndId(String id, Long categoryId);
    void deleteCategoryByCounselorProfile_Counselor_IdAndId(String counselorId, Long categoryId);
}
