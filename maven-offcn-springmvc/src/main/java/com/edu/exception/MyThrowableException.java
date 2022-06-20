package com.edu.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyThrowableException {
    @ExceptionHandler(value = {NullPointerException.class})
    public String nullException(){
        System.out.println("nullException");
        return "jpg";
    }
    @ExceptionHandler(value = {Throwable.class})
    public String defaultException(){
        System.out.println("defaultException");
        return "jpg";
    }
}
