package kr.hs.dgsw.simple.service;

import kr.hs.dgsw.simple.domain.Person;

public interface PersonService {

    public Person addPerson(Person person);

    public Person readPerson(int idx);

}
