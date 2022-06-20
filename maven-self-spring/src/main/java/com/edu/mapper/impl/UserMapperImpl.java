package com.edu.mapper.impl;

import com.edu.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapperImpl implements UserMapper {
    @Override
    public void selectById() {
        System.out.println("11111111111111111111mapper");
    }
}
