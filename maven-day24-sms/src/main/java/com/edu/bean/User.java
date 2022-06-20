package com.edu.bean;

public class User {
    private Integer uid;
    private String username;
    private String password;
    private String photo;

    public User(String username, String password, String photo) {
        this.username = username;
        this.password = password;
        this.photo = photo;
    }

    public User(Integer uid, String username, String password, String photo) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.photo = photo;
    }

    public User() {
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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
}


