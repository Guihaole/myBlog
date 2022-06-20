package com.edu.controller.day01;

import com.edu.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class TestController {

    @RequestMapping("login")
    public String login(String username,String password){
        System.out.println(username);
        System.out.println(password);
        return "main";
    }
    //1.同名策略
    //2.对象接收
    //3.List map set 复杂对象  很简单
    //存值策略 model Map ModelMap
    @RequestMapping("/type")
    public String type(String username, String password, Model model, ModelMap modelMap, Map map){
        model.addAttribute("username",username);
        modelMap.addAttribute("username2",username);
        map.put("username3",username);
        return "main";
    }
    @ResponseBody
    @RequestMapping("/jsonTest")
    public Student json(){
        return new Student("1111"
                ,"2222fddss",
                "3369633");
    }
}
