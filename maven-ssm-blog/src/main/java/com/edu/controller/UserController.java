package com.edu.controller;

import com.edu.bean.User;
import com.edu.service.UserService;
import com.edu.vo.ResultVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //http://localhost:6060/blog/user/selectUserPageInfo
    @GetMapping("/selectUserPageInfo")
    public PageInfo<User> selectUserPageInfo(@RequestParam(defaultValue = "1") Integer pageNum, String uName){
        PageInfo<User> pageInfo = userService.selectUserPageInfo(pageNum, uName);
        return pageInfo;
    }

    //http://localhost:6060/blog/user/selectUserPageInfo
    @GetMapping("/updateUserStatusByUid")
    public ResultVo updateUserStatusByUid(Integer uid,Integer status){
        int i = userService.updateUserStatusByUid(uid, status);
        if (i==1) {
            return new ResultVo("200","修改成功",null);
        }else{
            return new ResultVo("202","修改失败",null);
        }
    }

    //http://localhost:6060/blog/user/selectUser
    @GetMapping("/selectUser/{uid}")
    public User selectUser(@PathVariable("uid") Integer uid){
        return userService.selectUser(uid);
    }

    //http://localhost:6060/blog/user/login
    @GetMapping("/login")
    public ResultVo login(String username, String password, HttpSession session){
        return userService.login(username,password,session);
    }
    //http://localhost:6060/blog/user/loginSee
    @GetMapping("/loginSee")
    public ResultVo loginSee(HttpSession session){
        String userSession = (String)session.getAttribute("userSession");
        if (userSession==null) {
            return new ResultVo("202", "未登录", null);
        }else {
            return new ResultVo("200", "登录回显成功", userSession);
        }
    }
    //http://localhost:6060/blog/user/loginOut
    @GetMapping("/loginOut")
    public ResultVo loginOut(HttpSession session){
        session.invalidate();
        return new ResultVo("200","退出登录成功",null);
    }
}
