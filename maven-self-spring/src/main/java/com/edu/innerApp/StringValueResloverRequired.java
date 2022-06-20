package com.edu.innerApp;


import org.springframework.util.StringValueResolver;

public class StringValueResloverRequired implements StringValueResolver {

    @Override
    public String resolveStringValue(String s) {
        return s;
    }
}
