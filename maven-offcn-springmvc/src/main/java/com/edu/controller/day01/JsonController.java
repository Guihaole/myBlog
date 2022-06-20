package com.edu.controller.day01;

import com.edu.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/js")
public class JsonController {
    @ResponseBody
    @GetMapping("/jsonTest2")
    public Student json(){
        return new Student("1111","2222fddss","3369633");
    }
}
