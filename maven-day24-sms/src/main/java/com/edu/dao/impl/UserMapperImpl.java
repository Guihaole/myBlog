package com.edu.dao.impl;

import com.edu.bean.User;
import com.edu.dao.UserMapper;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.sql.DataSource;
import java.sql.SQLException;

//数据库操作
public class UserMapperImpl implements UserMapper {
    private DataSource dataSource=new ComboPooledDataSource();
    private QueryRunner queryRunner=new QueryRunner(dataSource);

    /**
     * 查询是否有这个用户
     * @param username
     * @param password
     * @return
     */
    @Override
    public User selectUserByNameAndPwd(String username, String password) {
        String sql="select * from user where username=? and password=?";
        User user=null;
        try {
            Object[] obj={username,password};
            user=queryRunner.query(sql,new BeanHandler<>(User.class),obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
