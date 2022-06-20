package com.offcn.bean;

public class User {
    private Integer uid; // 编号
    private String name; // 真实姓名
    private String phone; // 手机号
    private Integer age; // 年龄
    private Integer sex; // 性别 0：男 1：女
    private String username; // 用户名
    private String password; // 用户密码
    private String picture; // 用户头像路径
    private Integer status = 1; // 用户状态 1：启用 2：禁用
    private String createtime; // 注册时间
    private Integer role = 0; // 用户角色 0：学员 1：管理员

    public User() {
    }

    public User(Integer uid, String name,String phone) {
        this.uid = uid;
        this.name = name;
        this.phone=phone;
    }

    public User(String name, String phone, Integer age, Integer sex, String username, String password, String picture, Integer status, String createtime, Integer role) {
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.sex = sex;
        this.username = username;
        this.password = password;
        this.picture = picture;
        this.status = status;
        this.createtime = createtime;
        this.role = role;
    }

    public User(Integer uid, String name, String phone, Integer age, Integer sex, String username, String password, String picture, Integer status, String createtime, Integer role) {
        this.uid = uid;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.sex = sex;
        this.username = username;
        this.password = password;
        this.picture = picture;
        this.status = status;
        this.createtime = createtime;
        this.role = role;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
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
                ", picture='" + picture + '\'' +
                ", status=" + status +
                ", createtime='" + createtime + '\'' +
                ", role=" + role +
                '}';
    }
}
