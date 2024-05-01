package kr.hs.dgsw.simple.repository;

import kr.hs.dgsw.simple.entity.WritingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WritingRepository extends JpaRepository<WritingEntity, Integer> {
}
