package com.edu.controller.day02;

import com.edu.bean.Car;
import com.edu.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

//参数类型接收
@Controller
public class ParamsController {

    //http://localhost:6060/paramsEquals
    @RequestMapping("/paramsEquals")
    public String paramsEquals(String username,String password){
        System.out.println(username);
        System.out.println(password);
        return "";
    }
    //http://localhost:6060/paramsObject
    @RequestMapping("/paramsObject")
    public String paramsObject(Student student){
        System.out.println(student);
        return "";
    }
    //http://localhost:6060/paramsObjects
    @RequestMapping("/paramsObjects")
    public String paramsObjects(Student student, Car car){
        System.out.println(student);
        System.out.println(car);
        return "";
    }
    //http://localhost:6060/paramsStuAndCar
    @RequestMapping("/paramsStuAndCar")
    public String paramsStuAndCar(Student student){
        System.out.println(student);
        return "";
    }
    //http://localhost:6060/paramsStuAndCarList
    @RequestMapping("/paramsStuAndCarList")
    public String paramsStuAndCarList(Student student){
        System.out.println(student);
        return "";
    }
    //http://localhost:6060/paramsStuAndCarSet
    @RequestMapping("/paramsStuAndCarSet")
    public String paramsStuAndCarSet(Student student){
        System.out.println(student);
        return "";
    }
    //http://localhost:6060/paramsStuAndMap
    @RequestMapping("/paramsStuAndMap")
    public String paramsStuAndMap(Student student){
        System.out.println(student);
        return "";
    }
    //http://localhost:6060/params
    @RequestMapping(path = "/params")
    public String params(@RequestParam(name = "username") String name,@RequestParam(name = "password") String pwd){
        System.out.println(name+"---------"+pwd);
        return "";
    }
    //http://localhost:6060/paramsMap
    @RequestMapping(path = "/paramsMap")
    public String paramsMap(@RequestParam Map<String,String> map){
        System.out.println(map.get("username"));
        System.out.println(map.get("password"));
        return "";
    }
    //http://localhost:6060/pathParams/1001/guihaole
    @GetMapping("/pathParams/{id}/{name}")
    public String pathParams(@PathVariable(name = "id",required = true) String id, @PathVariable("name") String name){
        System.out.println(id);
        System.out.println(name);
        return "";
    }
    //http://localhost:6060/pathParamsMap/1001/guihaole
    @GetMapping("/pathParamsMap/{id}/{name}")
    public String pathParamsMap(@PathVariable Map<String,String> map){
        System.out.println(map.get("id"));
        System.out.println(map.get("name"));
        return "";
    }
    //http://localhost:6060/requestBodyJson  post
    @PostMapping("/requestBodyJson")
    public String requestBodyJson(@RequestBody Student student){
        System.out.println(student);
        return "";
    }
    //http://localhost:6060/upload  post
    @PostMapping("/upload")
    public String requestBodyJson(MultipartFile source){
        System.out.println(source.getOriginalFilename());
        return "";
    }
}
