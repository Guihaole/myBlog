package com.edu.controller;

import com.edu.bean.User;
import com.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //http://localhost:6060/user/selectUserList
    @ResponseBody
    @GetMapping("/selectUserList")
    public List<User> selectUserList() {
        return userService.selectUserList();
    }
}
