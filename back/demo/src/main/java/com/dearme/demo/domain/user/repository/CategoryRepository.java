package com.dearme.demo.domain.user.repository;

import com.dearme.demo.domain.user.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
