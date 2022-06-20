package com.edu.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//baseServlet分发到其他方法
public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //乱码处理
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //接收方法参数
        String method = req.getParameter("method");
        Class<? extends BaseServlet> aClass = this.getClass();
        try {
            Method method2 = aClass.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            method2.setAccessible(true);
            method2.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
