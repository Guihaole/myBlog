package com.edu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class TokenAndEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        //放行的拦截路径
        boolean flag1 = url.contains("login.jsp");
        boolean flag2 = url.contains("code");
        boolean flag3 = url.contains("31.jpg");
        boolean flag4 = url.contains("user");
        boolean flag5 = url.contains("1.gif");
        if (flag1||flag2||flag3||flag4||flag5) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            //校验session
            HttpSession session = request.getSession();
            Object user = session.getAttribute("user");
            if (user==null) {
                response.sendRedirect("login.jsp");
            }else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
