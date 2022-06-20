package com.offcn.innerClass;

import com.offcn.end.Photo;
import com.offcn.end.Reflection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class EndTest {
    public Reflection reflection=new Reflection();
    @Before
    //反射创建的三种方式
    public void createReflect() throws ClassNotFoundException {
        reflection.createReflect();
    }
    @Test
    //反射的应用
    public void useReflect() throws Exception {
      reflection.useReflect();
    }
    @After
    public void getInterface() throws Exception{
        reflection.getInterface();
    }
}
