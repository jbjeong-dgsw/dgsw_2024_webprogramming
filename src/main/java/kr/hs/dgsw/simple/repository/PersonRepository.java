package kr.hs.dgsw.simple.repository;

import kr.hs.dgsw.simple.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
}
