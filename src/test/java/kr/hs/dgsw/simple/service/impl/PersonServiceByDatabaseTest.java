package kr.hs.dgsw.simple.service.impl;

import kr.hs.dgsw.simple.domain.Person;
import kr.hs.dgsw.simple.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceByDatabaseTest {

    @Autowired
    private PersonService personService;

    @Test
    public void testReadPerson() {
        List<Person> list = personService.readPerson("zzz@test.com");
        assertEquals(2, list.size());

        list = personService.readPerson("none@afajkj.afafa");
        assertEquals(0, list.size());

    }

}