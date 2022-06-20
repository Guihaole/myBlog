package com.edu.framework.protocol.http;

import com.edu.framework.Invocation;
import com.edu.framework.register.LocalRegister;
import org.apache.commons.io.IOUtils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;

public class HttpServerHandler {
    public void handler(HttpServletRequest request, HttpServletResponse response) {
        try {
            Invocation invocation = (Invocation) new ObjectInputStream(request.getInputStream()).readObject();
            String interfaceName = invocation.getInterfaceName();
            String methodName = invocation.getMethodName();
            //如何根据接口名调到相应的接口实现类呢? 注册
            Class implClass = LocalRegister.get(interfaceName);
            try {
                //反射调用
                Method method = implClass.getMethod(methodName, invocation.getParamTypes());
                String res = (String) method.invoke(implClass.newInstance(), invocation.getParams());
                IOUtils.write(res,response.getOutputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
