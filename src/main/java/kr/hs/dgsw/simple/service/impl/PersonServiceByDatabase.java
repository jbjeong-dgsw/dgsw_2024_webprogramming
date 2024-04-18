package kr.hs.dgsw.simple.service.impl;

import kr.hs.dgsw.simple.domain.Person;
import kr.hs.dgsw.simple.entity.PersonEntity;
import kr.hs.dgsw.simple.repository.PersonRepository;
import kr.hs.dgsw.simple.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Primary
public class PersonServiceByDatabase implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person addPerson(Person person) {
        PersonEntity entity = new PersonEntity();
        entity.setName(person.getName());
        entity.setEmail(person.getEmail());
        entity.setAge(person.getAge());
        entity.setFilePath(person.getFilePath());

        personRepository.save(entity);

        person.setIdx(entity.getIdx());

        return person;
    }

    @Override
    public Person readPerson(int idx) {
        Optional<PersonEntity> optional = personRepository.findById(idx);
        PersonEntity entity = optional.orElse(null);

        if (entity == null) {
            return null;
        }

        Person person = new Person();
        person.setIdx(entity.getIdx());
        person.setName(entity.getName());
        person.setEmail(entity.getEmail());
        person.setAge(entity.getAge());
        person.setFilePath(entity.getFilePath());

        return person;
    }

    @Override
    public Person updatePerson(Person person) {
        return null;
    }
}
