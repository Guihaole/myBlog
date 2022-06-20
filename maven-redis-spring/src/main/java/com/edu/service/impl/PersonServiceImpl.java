package com.edu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.edu.bean.Person;
import com.edu.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private JedisPool jedisPool;

    @Override
    public void setPerson(Person person) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.setex("person",600, JSON.toJSONString(person));
        } finally {
            jedis.close();
        }
    }

    @Override
    public Person getPerson() {
        Jedis jedis = jedisPool.getResource();
        Person person=null;
        try {
            String s = jedis.get("person");
            person=JSON.parseObject(s,Person.class);
        } finally {
            jedis.close();
        }
        return person;
    }

    @Override
    public void setPersonList(List<Person> personList) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.setex("personList",600, JSON.toJSONString(personList));
        } finally {
            jedis.close();
        }
    }

    @Override
    public List<Person> getPersonList() {
        Jedis jedis = jedisPool.getResource();
        List<Person> personList=null;
        try {
            String s = jedis.get("personList");
            personList=JSON.parseObject(s,new TypeReference<List<Person>>(){});
        } finally {
            jedis.close();
        }
        return personList;
    }
}
