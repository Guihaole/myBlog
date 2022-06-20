package com.edu.service.impl;

import com.edu.bean.User;
import com.edu.bean.UserExample;
import com.edu.mapper.UserMapper;
import com.edu.service.UserService;
import com.edu.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 分页查询功能带模糊
     *
     * @param pageNum 当前页码值
     * @param uName   查询用户的模糊查询条件
     * @return
     */
    @Override
    public PageInfo<User> selectUserPageInfo(Integer pageNum, String uName) {
        PageHelper.startPage(pageNum, 3);
        List<User> userList = null;
        UserExample userExample = new UserExample();
        if (uName == null || "".equals(uName)) {
            userList = userMapper.selectByExample(null);
        } else {
            userExample.createCriteria().andUnameLike("%" + uName + "%");
            userList = userMapper.selectByExample(userExample);
        }
        PageInfo<User> pageInfo = new PageInfo<>(userList, 4);
        return pageInfo;
    }

    /**
     * 解冻功能，根据uid修改装status信息
     *
     * @param uid
     * @param status
     * @return
     */
    @Override
    public int updateUserStatusByUid(Integer uid, Integer status) {
        User user = new User();
        user.setUid(uid);
        user.setStatus(status);
        int res = userMapper.updateByPrimaryKeySelective(user);
        return res;
    }

    /**
     * 根据uid查询个人信息
     *
     * @param uid
     * @return
     */
    @Override
    public User selectUser(Integer uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    /**
     * 登录功能
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public ResultVo login(String username, String password, HttpSession session) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUnameEqualTo(username).andUpassEqualTo(password);
        List<User> userList = userMapper.selectByExample(userExample);
        User user = null;
        if (userList != null && userList.size() > 0) {
            user = userList.get(0);
        }
        if (user == null) {
            return new ResultVo("202", "用户名或者密码错误", null);
        } else {
            if (user.getUtype() != 1) {
                return new ResultVo("202", "你不是管理员，不能登录", null);
            } else if (user.getStatus() == 1) {
                return new ResultVo("202", "你的账号已经冻结，不能登录", null);
            } else {
                session.setAttribute("userSession",user.getTruename());
                session.setAttribute("userId",user.getUid());
                return new ResultVo("200", "登录成功", user);
            }
        }
    }

}
