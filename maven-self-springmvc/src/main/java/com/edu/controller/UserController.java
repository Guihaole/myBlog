package com.edu.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.edu.bean.User;
import com.edu.bean.UserVo;
import com.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //跳转方式
    @GetMapping("/test")
    public String testUserConfig() {
        System.out.println("111111");
        return "index";
    }

    @ResponseBody
    @GetMapping("/select")
    public List<User> selectUser() {
        return userService.selectUser();
    }

    @GetMapping("/forward")
    public String forward() {
        return "forward:/html/index.html";
    }

    @GetMapping("/redicrect")
    public String redicrect() {
        return "redirect:http://www.baidu.com";
    }

    @GetMapping("/modelandview")
    public ModelAndView modelandview(Model model2) {
        ModelAndView modelAndView = new ModelAndView();
        model2.addAttribute("123456", "helloworld");
        model2.addAttribute("wd", "admin");
        modelAndView.setViewName("redirect:http://www.baidu.com");
        return modelAndView;
    }

    @GetMapping("/modelandview2")
    public ModelAndView modelandview2(Model model2) {
        ModelAndView modelAndView = new ModelAndView();
        model2.addAttribute("123456", "helloworld");
        model2.addAttribute("guihaole", "admin");
        modelAndView.setViewName("index");
        return modelAndView;
    }
    //收参测试

    //收参--同名策略
    //    http://localhost:6060/user/base?name=guihaole&psw=123456&date=2000-09-09 10:56:02
    @GetMapping("/base")
    public void baseParams(String name, String psw, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
        System.out.println(name + "-----" + psw + "----" + date);
    }

    @GetMapping("/shiti")
    //收参---实体数据收参
    //    http://localhost:6060/user/shiti?uid=1&username=guihaole&password=123456
    @ResponseBody
    public String ShiTiParams(User user) {
        System.out.println(user.getUid() + "-----" + user.getUsername() + "----" + user.getPassword());
        return "success";
    }

    @ResponseBody
    @GetMapping("/arr")
    //数组类型收参
    //    http://localhost:6060/user/arr
    public String arrParams(String[] arr) {
        System.out.println(Arrays.toString(arr));
        return "success";
    }

    @GetMapping("/annation")
    //注解类型收参
    //   http://localhost:6060/user/annation?name=1&psw=123456
    public void collectionParams(@RequestParam("name") String username, @RequestParam("psw") String password) {
        System.out.println(username + "-----" + password);
    }

    @GetMapping("/annationMap")
    //   http://localhost:6060/user/annationMap?name=1&psw=123456
    public void collectionParams(@RequestParam Map<String, String> map) {
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }
    }

    //url收参
    //   http://localhost:6060/user/url/1
    @GetMapping("/url/{id}")
    public void urlParams(@PathVariable("id") String uid) {
        System.out.println(uid);
    }

    @PostMapping("/json")
    //json对象收参
    // http://localhost:6060/user/json
    @ResponseBody
    public String jsonParams(@RequestBody User user) {
        System.out.println(user);
        return "success";
    }

    //测试json数据和异常解析器
    //  http://localhost:6060/user/jsonUser
    @GetMapping("/jsonUser")
    @ResponseBody
    public UserVo jsonUser() {
        int i = 1 / 0;
        UserVo vo = new UserVo(1, "guihaole", null, new Date(), "上海");
        return vo;
    }

    //这玩意不需要加那个二进制注解
    @PostMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile source) {
        System.out.println(source.getOriginalFilename());
        return "success";
    }
}
