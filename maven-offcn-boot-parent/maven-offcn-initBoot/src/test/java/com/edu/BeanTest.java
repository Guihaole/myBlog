package com.edu;

import com.edu.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest {
    @Autowired
    private Person person;
    @Test
    public void test1(){
        System.out.println(person);
    }
}
