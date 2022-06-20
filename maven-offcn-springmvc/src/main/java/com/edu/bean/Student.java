package com.edu.bean;

import java.io.Serializable;
import java.util.*;

public class Student implements Serializable {
    private String username;
    private String password;
    private String address;
    private Car car;
    private List<Car> carList;
    private Set<Car> carSet=new HashSet<>();
    private Map<String, Car> map=new HashMap<>();

    public Student() {
        carSet.add(new Car());
        carSet.add(new Car());
        carSet.add(new Car());
    }

    public Map<String, Car> getMap() {
        return map;
    }

    public void setMap(Map<String, Car> map) {
        this.map = map;
    }

    public Set<Car> getCarSet() {
        return carSet;
    }

    public void setCarSet(Set<Car> carSet) {
        this.carSet = carSet;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Student(String username, String password, String address) {
        this.username = username;
        this.password = password;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", car=" + car +
                ", carList=" + carList +
                ", carSet=" + carSet +
                ", map=" + map +
                '}';
    }
}
