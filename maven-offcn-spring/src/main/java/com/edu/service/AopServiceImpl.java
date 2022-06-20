package com.edu.service;

import org.springframework.stereotype.Service;

//定义业务类
@Service
public class AopServiceImpl {
    public void aopAspect(){
        System.out.println("开始转账");
        //int a=1/0;
        System.out.println("转账完成");
    }
}
