package com.offcn.dao;

import com.offcn.bean.User;

import java.util.List;

public interface UserMapper {
    User selectUserByNameAndPwd(String username, String password);

    int addUser(User user);

    List<User> selectUserAll(int startIndex, int pageSize, String search);

    int selectTotalCount(String search);

    int updateUserByUid(User user);

    int deleteUser(int parseInt);

    User selectUserByName(String name);

    User selectByPhoneUser(String phone);

    User selectUserByPhoneAndPwd(String phone, String password);
}
