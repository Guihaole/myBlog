package com.offcn.service;

import com.offcn.bean.User;

import java.util.List;

public interface UserService {
    User selectUserByNameAndPwd(String username,String password);

    int addUser(User user);

    List<User> selectUserAll(int startIndex, int pageSize, String search);

    int selectTotalCount(String search);

    int updateUser(User user);

    int deleteCheckedUser(String delarr);

    User selectByPhoneUser(String phone);

    User selectUserByPhoneAndPwd(String phone, String password);
}
