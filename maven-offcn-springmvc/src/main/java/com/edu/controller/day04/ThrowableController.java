package com.edu.controller.day04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThrowableController {
    //http://localhost:6060/nullExceptionMethod
    @RequestMapping("/nullExceptionMethod")
    public String nullExceptionMethod(){
        String a=null;
        System.out.println(a.length());
        return "main";
    }
    //http://localhost:6060/outFoundExceptionMethod
    @RequestMapping("/outFoundExceptionMethod")
    public String outFoundExceptionMethod(){
        String[] aa={"bb"};
        System.out.println(aa[5]);
        return "main";
    }
}
