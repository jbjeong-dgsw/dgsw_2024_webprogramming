package kr.hs.dgsw.simple.service.impl;

import kr.hs.dgsw.simple.domain.Person;
import kr.hs.dgsw.simple.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final List<Person> buffer = new ArrayList<>();

    private int idPool = 0;

    @Override
    public Person addPerson(Person person) {
        idPool++;

        person.setIdx(idPool);
        buffer.add(person);

        return person;
    }

    @Override
    public Person readPerson(int idx) {
        for (Person person : buffer) {
            if (person.getIdx() == idx) {
                return person;
            }
        }

        throw new RuntimeException("Not Found");
    }

    @Override
    public Person updatePerson(Person person) {
        Person saved = readPerson(person.getIdx());

        saved.setName(person.getName());
        saved.setEmail(person.getEmail());
        saved.setAge(person.getAge());

        return saved;
    }

}
