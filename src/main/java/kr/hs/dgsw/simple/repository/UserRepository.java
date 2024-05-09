package kr.hs.dgsw.simple.repository;

import kr.hs.dgsw.simple.entity.UserEntity;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    public Optional<UserEntity> findByEmail(String email);

    @Modifying
    @Query("UPDATE UserEntity u SET withdrawedYn = 'Y', withdrawedTime = :time WHERE u.userIdx = :userIdx ")
    public void updateUserWithdrawed(@Param("userIdx") int userIdx,
                                     @Param("time") Date time);

}
