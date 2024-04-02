package me.leeminjeong.springbootdeveloper.repository;

import me.leeminjeong.springbootdeveloper.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); // email로 사용자 정보를 가져옴
    // Optional은 NullPointerException를 방지하기 위해 사용
}
