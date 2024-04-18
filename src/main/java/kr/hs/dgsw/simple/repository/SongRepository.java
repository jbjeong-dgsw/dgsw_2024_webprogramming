package kr.hs.dgsw.simple.repository;

import kr.hs.dgsw.simple.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SongRepository extends JpaRepository<SongEntity, Integer> {

    public Optional<SongEntity> findByTitle(String title);

}
