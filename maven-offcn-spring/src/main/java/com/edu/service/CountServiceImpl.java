package com.edu.service;

import com.edu.dao.CountMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class CountServiceImpl implements CountService{
    @Resource
    private CountMapper countMapper;
    //转账方法
    //    @Transactional
    @Override
    public void moneyCount(String nameFrom, String nameTo, Double money){
        System.out.println("开始转账");
        countMapper.decrMoney(nameFrom,money);
        //int a=1/0;
        System.out.println("转账中");
        countMapper.incrMoney(nameTo,money);
        System.out.println("成功转账");
    }
}
