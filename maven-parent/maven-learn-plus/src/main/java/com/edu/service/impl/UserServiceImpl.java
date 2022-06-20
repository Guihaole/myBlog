package com.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.mapper.UserMapper;
import com.edu.pojo.User;
import com.edu.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
