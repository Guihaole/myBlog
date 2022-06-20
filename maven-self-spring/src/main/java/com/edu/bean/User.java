package com.edu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements InitializingBean, DisposableBean {
    private String uid;
    private String user_name;
    private String user_password;
    public void init(){
        System.out.println("初始化initMethod");
    }
    public void destory(){
        System.out.println("销毁initDestory");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁initDestory---接口实现");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化initMethod---接口实现");
    }
}
