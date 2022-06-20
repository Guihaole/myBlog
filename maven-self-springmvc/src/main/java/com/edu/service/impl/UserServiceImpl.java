package com.edu.service.impl;

import com.edu.bean.User;
import com.edu.mapper.UserMapper;
import com.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> selectUser() {
        return userMapper.selectUser();
    }
}
