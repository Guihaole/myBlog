package com.offcn.service.impl;

import com.offcn.bean.User;
import com.offcn.dao.UserMapper;
import com.offcn.dao.impl.UserMapperImpl;
import com.offcn.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper=new UserMapperImpl();
    @Override
    public User selectUserByNameAndPwd(String username,String password) {
        return userMapper.selectUserByNameAndPwd(username,password);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public List<User> selectUserAll(int startIndex, int pageSize, String search) {
        return userMapper.selectUserAll(startIndex,pageSize,search);
    }

    @Override
    public int selectTotalCount(String search) {
        return userMapper.selectTotalCount(search);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUserByUid(user);
    }

    @Override
    public int deleteCheckedUser(String delarr) {
        String[] split = delarr.split(",");
        int res=0;
        for (String s : split) {
            res=res+userMapper.deleteUser(Integer.parseInt(s));
        }
        return res;
    }

    @Override
    public User selectByPhoneUser(String phone) {
        return userMapper.selectByPhoneUser(phone);
    }

    @Override
    public User selectUserByPhoneAndPwd(String phone, String password) {
        return userMapper.selectUserByPhoneAndPwd(phone,password);
    }
}
