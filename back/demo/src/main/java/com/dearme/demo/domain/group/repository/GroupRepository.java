package com.dearme.demo.domain.group.repository;

import com.dearme.demo.domain.group.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
