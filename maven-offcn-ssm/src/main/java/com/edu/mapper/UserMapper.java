package com.edu.mapper;

import com.edu.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    public List<User> selectUserList();
}
