package com.edu.service.impl;

import com.edu.mapper.UserMapper;
import com.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    //Qualifer----假如容器中一个类的类型对应两个bean对象,可以指定装配
    //@Resource----和autowired的使用放式相同，唯一不同的是它不可以配合其他注解
    //@Inject----要导包
    private UserMapper userMapper;
    @Override
    public void systemPrint() {
      userMapper.selectById();
    }
}
