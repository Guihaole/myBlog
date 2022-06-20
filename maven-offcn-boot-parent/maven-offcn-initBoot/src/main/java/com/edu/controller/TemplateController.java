package com.edu.controller;

import com.edu.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
@Api(tags = "模板引擎管理")
@Controller
@RequestMapping("/template")
public class TemplateController {
    @ApiOperation(value = "test01测试")
    @RequestMapping("/test01")
    public String Test01(Model model){
        model.addAttribute("el", "<h3>我爱学习</h3>");

        User u = new User();
        u.setId(1l);
        u.setName("优就业");
        u.setAge(18);
        model.addAttribute("user", u);

        Map<String,Object> map=new HashMap<>();
        map.put("src1","1.jpg");
        map.put("src2","2.jpg");
        map.put("src3","http://www.baidu.com");
        model.addAttribute("src", map);
        return "test01";
    }
    @ApiOperation(value = "test02测试")
    @RequestMapping("/test02")
    public String test02(Model model){
        List<User> list=new ArrayList<User>();
        User u1 = new User();
        u1.setId(1l);
        u1.setName("优就业");
        u1.setAge(18);
        list.add(u1);

        User u2 = new User();
        u2.setId(2l);
        u2.setName("中公教育");
        u2.setAge(28);
        list.add(u2);
        User u3 = new User();
        u3.setId(3l);
        u3.setName("IT先锋");
        u3.setAge(88);
        list.add(u3);

        User u4 = new User();
        u4.setId(4l);
        u4.setName("JAVA第一");
        u4.setAge(888);
        list.add(u4);
        model.addAttribute("userList", list);
        return "test02";
    }
    @ApiOperation(value = "test03测试")
    @RequestMapping("/test03")
    public String test03(Model model){
        model.addAttribute("userName", "优就业");
        model.addAttribute("href", "http://www.baidu.com");
        return "test03";
    }
    @ApiOperation(value = "test04测试")
    @RequestMapping("/test04")
    public String test04(Model model){
        model.addAttribute("flag", "yes");
        model.addAttribute("age", 18);
        return "test04";
    }
    @ApiOperation(value = "test05测试")
    @RequestMapping("/test05")
    public String test05(Model model, HttpSession session, HttpServletRequest request){
        model.addAttribute("testStr", "abcdefgh");
        model.addAttribute("newDate", new Date());
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1l,"aa",12));
        model.addAttribute("userList",users);
        session.setAttribute("sessionContext","1233");
        session.getServletContext().setAttribute("servletContext","1111");
        request.setAttribute("requestContext","request1111");
        return "test05";
    }
    @ApiOperation(value = "test06测试")
    @RequestMapping("/test06")
    public String test06(Model model){
        return "test06";
    }
    @ApiOperation(value = "test07测试")
    @RequestMapping("/test07")
    public String test07(Model model){
        return "test07";
    }
}
