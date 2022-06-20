package com.edu.servlet;

import com.edu.bean.User;
import com.edu.service.UserService;
import com.edu.service.impl.UserServiceImpl;
import com.edu.util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends BaseServlet {

    private UserService userService=new UserServiceImpl();
    /**
     * 登录功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //收参
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        String cookieFlag = req.getParameter("cookieFlag");//判断是否记住密码的标记，发送cookie的时机
        //参数处理
        //1.验证码校验
        HttpSession session = req.getSession();
        String sessionCode = (String)session.getAttribute("sessionCode");
        if (sessionCode.equalsIgnoreCase(code)) {
            //2.用户名和密码校验
            User user=userService.selectUserByNameAndPwd(username,password);
            if (user!=null) {



                //登录成功
                if ("cookieFlag".equals(cookieFlag)) {
                    //1.创建cookie
                    Cookie cookie1 = new Cookie("username",username);
                    Cookie cookie2 = new Cookie("password",password);
                    //2.设置cookie的生存时间
                    cookie1.setMaxAge(60*60*24*7);
                    cookie2.setMaxAge(60*60*24*7);
                    //3.设置cookie的作用域
                    cookie1.setPath(req.getServletContext().getContextPath()+"/login.jsp");
                    cookie2.setPath(req.getServletContext().getContextPath()+"/login.jsp");
                    //4.响应
                    resp.addCookie(cookie1);
                    resp.addCookie(cookie2);
                }


                session.setAttribute("user",user);
                resp.sendRedirect("index.jsp");
            }else {
                //用户名密码错误
                req.setAttribute("error","用户或密码错误");
                req.getRequestDispatcher("login.jsp").forward(req,resp);

            }
        }else {
            req.setAttribute("error","验证码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    /**
     * 退出功能
     * @param request
     * @param response
     */
    private void loginOut(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //1.删除session中的会话，解绑
        HttpSession session = request.getSession();
        session.invalidate();
        //2.重定向到登录页面
        response.sendRedirect("login.jsp");
    }
}
