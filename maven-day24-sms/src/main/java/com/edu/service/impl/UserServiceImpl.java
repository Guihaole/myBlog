package com.edu.service.impl;

import com.edu.bean.User;
import com.edu.dao.UserMapper;
import com.edu.dao.impl.UserMapperImpl;
import com.edu.service.UserService;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper=new UserMapperImpl();
    @Override
    public User selectUserByNameAndPwd(String username, String password) {
        return userMapper.selectUserByNameAndPwd(username,password);
    }
}
