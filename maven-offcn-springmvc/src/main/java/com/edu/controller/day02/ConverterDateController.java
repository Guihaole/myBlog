package com.edu.controller.day02;

import com.edu.bean.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//测试转换器
public class ConverterDateController {
    //http://localhost:6060/paramsDate
    @RequestMapping("/paramsDate")
    public String paramsDate(Car car){
        System.out.println(car);
        return "";
    }
}
