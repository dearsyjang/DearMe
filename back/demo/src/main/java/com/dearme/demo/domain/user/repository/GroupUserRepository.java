package com.dearme.demo.domain.user.repository;

import com.dearme.demo.domain.user.entity.GroupUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupUserRepository extends JpaRepository<GroupUser, Long> {
    List<GroupUser> findAllByUser_Id(String id);
    void deleteGroupUserByUser_IdAndGroup_Id(String userId, Long groupId);
}
