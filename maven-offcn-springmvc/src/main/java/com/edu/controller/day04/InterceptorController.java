package com.edu.controller.day04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//拦截器
@Controller
public class InterceptorController {
    //http://localhost:6060/interceptor
    @RequestMapping("/interceptor")
    public String interceptor(){
        System.out.println("我执行了");
        return "jpg";
    }
}
