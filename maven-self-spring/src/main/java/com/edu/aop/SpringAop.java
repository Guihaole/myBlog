package com.edu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class SpringAop {
    @Pointcut("execution(public int com.edu.aop.AspectClass.*(..))")
    public void pointCut(){

    }
    @After("com.edu.aop.SpringAop.pointCut()")
    public void AfterProp(){
        System.out.println("方法之后通知");
    }
}
