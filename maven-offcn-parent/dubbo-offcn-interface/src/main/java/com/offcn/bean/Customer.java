package com.offcn.bean;

import java.io.Serializable;

public class Customer implements Serializable {
    private int id;
    private String name;
    private int age;
    private String home;

    public Customer() {
    }

    public Customer(int id, String name, int age, String home) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.home = home;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", home='" + home + '\'' +
                '}';
    }
}

