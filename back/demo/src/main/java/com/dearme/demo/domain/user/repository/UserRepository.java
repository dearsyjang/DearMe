package com.dearme.demo.domain.user.repository;

import com.dearme.demo.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserById(String id);
    Optional<User> findUserByIdAndPw(String id, String pw);
    Optional<User> findUserByRefreshToken(String refreshToken);
    boolean existsUserById(String id);
    boolean existsUserByNickName(String nickName);
    void deleteUserById(String id);
}
