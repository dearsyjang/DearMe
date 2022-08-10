package com.dearme.demo.domain.user.repository;

import com.dearme.demo.domain.user.entity.Type;
import com.dearme.demo.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserById(String id);
    Optional<User> findUserByIdAndPw(String id, String pw);
    Optional<User> findUserByRefreshToken(String refreshToken);
    boolean existsUserById(String id);
    boolean existsUserByNickName(String nickName);
    void deleteUserById(String id);

    List<User> findUserByTypeEquals(Type type);
    Optional<User> findUserByIdAndTypeEquals(String id, Type type);
}
