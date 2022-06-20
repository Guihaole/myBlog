package com.edu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//定义: 切面 = 切点 + 通知
@Component
@Aspect
public class TxManagerAspect {
    @Pointcut("execution(void com.edu.service.AopServiceImpl.aopAspect(..))")
    public void pc() {
    }

    @Before("pc()")
    //方法前
    public void begin() {
        System.out.println("开启事务");
    }

    @AfterReturning("pc()")
    //后置，发生异常不通知
    public void commit() {
        System.out.println("提交事务");
    }

    @AfterThrowing("pc()")
    //发生异常通知
    public void rollback() {
        System.out.println("回滚事务");
    }

    @After("pc()")
    //最终通知
    public void close() {
        System.out.println("关闭事务，释放资源");
    }

    //@Around("pc()")
    //环绕通知
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            begin();
            proceedingJoinPoint.proceed();
            commit();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            rollback();
        } finally {
            close();
        }
    }
}
