package com.edu.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("hello")
    public String hello() {
        return "hello spring security";
    }
    @PostMapping("success")
    public String success() {
        return "success spring security";
    }
    @PostMapping("fail")
    public String fail() {
        return "fail spring security";
    }
}
