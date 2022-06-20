package com.edu.servlet;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/code")
public class CodeCreateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/jpg;charset=utf-8");
        //生成验证码
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(100, 50, 4, 20);
        String code = captcha.getCode();
        req.getSession().setAttribute("sessionCode",code);
        captcha.write(resp.getOutputStream());


    }
}
