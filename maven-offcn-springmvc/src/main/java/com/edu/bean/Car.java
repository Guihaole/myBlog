package com.edu.bean;

import java.io.Serializable;
import java.util.Date;

public class Car implements Serializable {
    private String name;
    private String color;
    private Date date;

    public Car() {
    }

    public Car(String name, String color,Date date) {
        this.name = name;
        this.color = color;
        this.date=date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", date=" + date +
                '}';
    }
}
