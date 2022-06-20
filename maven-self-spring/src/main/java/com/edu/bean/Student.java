package com.edu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String username;
    private String password;
    private String uid;
    @Autowired
    public void setInit(){
        this.username="guihaole";
        this.password="123456";
        System.out.println("我在使用autowired");
    }
    @PostConstruct
    public void init() {
        System.out.println("初始化initMethod");
    }
    @PreDestroy
    public void destory() {
        System.out.println("销毁initDestory");
    }

}
