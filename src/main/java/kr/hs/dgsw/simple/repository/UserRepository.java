package kr.hs.dgsw.simple.repository;

import kr.hs.dgsw.simple.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    public Optional<UserEntity> findByEmail(String email);

}
