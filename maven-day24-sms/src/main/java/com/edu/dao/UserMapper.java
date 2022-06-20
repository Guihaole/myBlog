package com.edu.dao;

import com.edu.bean.User;

public interface UserMapper {
    User selectUserByNameAndPwd(String username, String password);
}
