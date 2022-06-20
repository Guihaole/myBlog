package com.edu.service;

import com.edu.bean.Person;

import java.util.List;

public interface PersonService {
    //存入对象
    public void setPerson(Person person);
    //取出对象
    public Person getPerson();
    //存入数组
    public void  setPersonList(List<Person> personList);
    //取出数组
    public List<Person> getPersonList();

}
