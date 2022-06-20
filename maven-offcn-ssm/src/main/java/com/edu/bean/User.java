package com.edu.bean;


import java.util.Date;

public class User {

  private Integer uid;
  private String name;
  private String phone;
  private Integer age;
  private Integer sex;
  private String username;
  private String password;
  private Integer status;
  private Date createtime;
  private Integer role;
  private String picture;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
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


  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Date getCreatetime() {
    return createtime;
  }

  public void setCreatetime(Date createtime) {
    this.createtime = createtime;
  }

  public Integer getRole() {
    return role;
  }

  public void setRole(Integer role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "User{" +
            "uid=" + uid +
            ", name='" + name + '\'' +
            ", phone='" + phone + '\'' +
            ", age=" + age +
            ", sex=" + sex +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", status=" + status +
            ", createtime=" + createtime +
            ", role=" + role +
            ", picture='" + picture + '\'' +
            '}';
  }
}
