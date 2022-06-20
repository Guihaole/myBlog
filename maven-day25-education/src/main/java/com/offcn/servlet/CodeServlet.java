package com.offcn.servlet;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.json.JSONUtil;
import com.offcn.util.BaseServlet;
import com.offcn.vo.ResultVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/code")
public class CodeServlet extends BaseServlet {
    private String codeTime; //临时存储code
    /**
     * 创建验证码  http://localhost:6060/education/code?method=createCode
     * @param request
     * @param response
     */
   private void createCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
       response.setContentType("image/jpg;charset=utf-8");
       //生成验证码
       LineCaptcha captcha = CaptchaUtil.createLineCaptcha(100, 50, 4, 20);
       String code = captcha.getCode();
       //request.getServletContext().setAttribute("code",code);
       codeTime=code;  //加载，请求createCode都需要更新code
       captcha.write(response.getOutputStream());
   }

    /**
     * 获取code http://localhost:6060/education/code?method=getCode
     * @param request
     * @param response
     */
   private void getCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
       ResultVo vo = new ResultVo(200,"验证码获取成功",codeTime);
       response.getWriter().write(JSONUtil.toJsonStr(vo));
   }
}
