package com.dearme.demo.domain.group.repository;

import com.dearme.demo.domain.group.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    void deleteGroupByCounselor_IdAndId(String counselorId, Long id);

    Optional<Group> findGroupByCounselor_IdAndId(String counselorId, Long id);
}
