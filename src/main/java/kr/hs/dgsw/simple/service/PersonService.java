package kr.hs.dgsw.simple.service;

import kr.hs.dgsw.simple.domain.Person;

import java.util.List;

public interface PersonService {

    public Person addPerson(Person person);

    public Person readPerson(int idx);

    public Person updatePerson(Person person);

    public List<Person> readPerson(String email);


}
