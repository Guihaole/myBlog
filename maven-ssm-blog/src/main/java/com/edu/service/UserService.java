package com.edu.service;

import com.edu.bean.User;
import com.edu.vo.ResultVo;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    //分页查询功能带模糊
    public PageInfo<User> selectUserPageInfo(Integer pageNum,String uName);
    //解冻功能，根据uid修改装status信息
    public int updateUserStatusByUid(Integer uid,Integer status);
    //根据uid查询个人信息
    public User selectUser(Integer uid);
    //登录功能
    public ResultVo login(String username, String password, HttpSession session);
}
