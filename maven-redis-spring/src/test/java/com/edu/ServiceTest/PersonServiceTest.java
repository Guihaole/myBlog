package com.edu.ServiceTest;

import com.edu.bean.Person;
import com.edu.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicatonContext.xml")
public class PersonServiceTest {
    @Autowired
    private PersonService personService;
    @Test
    public void personTest() {
        Person person = new Person(1, "aaa", "bbb", 18);
        personService.setPerson(person);
        System.out.println(personService.getPerson());
    }
    @Test
    public void personListTest() {
        List<Person> personList = Arrays.asList(
                new Person(1, "aaa", "bbb", 18),
                new Person(2, "aaa", "bbb", 18),
                new Person(3, "aaa", "bbb", 18)
        );
        personService.setPersonList(personList);
        personService.getPersonList().forEach(System.out::println);
    }
}
