package com.edu.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Student implements Serializable {
    private String address;
    private int[] arr;
    private List<Object> list;
    private Map<Object,Object> map;
    private Properties properties;
    private User user;

    public Student() {
    }

    public Student(String address, int[] arr, List<Object> list, Map<Object, Object> map, Properties properties, User user) {
        this.address = address;
        this.arr = arr;
        this.list = list;
        this.map = map;
        this.properties = properties;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Student{" +
                "address='" + address + '\'' +
                ", arr=" + Arrays.toString(arr) +
                ", list=" + list +
                ", map=" + map +
                ", properties=" + properties +
                ", user=" + user +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Map<Object, Object> getMap() {
        return map;
    }

    public void setMap(Map<Object, Object> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
