package com.edu.service;

import com.edu.bean.User;

public interface UserService {
    User selectUserByNameAndPwd(String username, String password);
}
