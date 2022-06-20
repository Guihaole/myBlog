package com.edu.bean;


import java.io.Serializable;

public class Count implements Serializable {

  private Integer id;
  private String name;
  private Double money;

  public Count() {
  }

  public Count(Integer id, String name, Double money) {
    this.id = id;
    this.name = name;
    this.money = money;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Double getMoney() {
    return money;
  }

  public void setMoney(Double money) {
    this.money = money;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }




}
