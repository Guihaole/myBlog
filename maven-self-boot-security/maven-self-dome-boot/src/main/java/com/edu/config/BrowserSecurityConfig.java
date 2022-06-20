package com.edu.config;

import com.edu.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailService userDetailService;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //httpBasic()默认方式 弹框
        http.formLogin() // 表单方式
                .loginPage("/login.html")//配置url为登录页面
                .loginProcessingUrl("/login")//登录请求的路径
                .successForwardUrl("/success")//登录成功跳转的页面
                .failureForwardUrl("/fail")//登录失败跳转的页面
                .and()
                .authorizeRequests() // 授权配置
                .antMatchers("/login.html","/hello").permitAll()//不需要认证的
                .anyRequest()  // 所有请求
                .authenticated()// 都需要认证
                .and().csrf().disable();
    }
}
