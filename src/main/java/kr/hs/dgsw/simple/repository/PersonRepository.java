package kr.hs.dgsw.simple.repository;

import kr.hs.dgsw.simple.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

    public List<PersonEntity> findAllByEmail(String email);

    public List<PersonEntity> findAllByEmailContaining(String email);

    public List<PersonEntity> findAllByName(String name);

    public List<PersonEntity> findAllByEmailAndName(String email, String name);

}
