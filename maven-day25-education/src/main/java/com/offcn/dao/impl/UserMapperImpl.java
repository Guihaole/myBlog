package com.offcn.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.bean.User;
import com.offcn.dao.UserMapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class UserMapperImpl implements UserMapper {
    private DataSource dataSource=new ComboPooledDataSource();
    private QueryRunner queryRunner=new QueryRunner(dataSource);
    /**
     * 根据用户名密码查询用户
     * @param username
     * @param password
     * @return
     */
    @Override
    public User selectUserByNameAndPwd(String username, String password) {
        String sql="select * from user where username=? and password=?";
        User user=null;
        Object[] obj={username,password};
        try {
            user=queryRunner.query(sql,new BeanHandler<>(User.class),obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    /**
     * 增加用户信息
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        String sql="insert into user values(?,?,?,?,?,?,?,?,?,?,?)";
        Object[] obj={null,user.getName(),user.getPhone(),user.getAge(),user.getSex()
        ,user.getUsername(),user.getPassword(),user.getStatus(),user.getCreatetime(),user.getRole(),null};
        int res=0;
        try {
            res=queryRunner.update(sql,obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    /**
     * 查询所有
     * @return
     * @param startIndex
     * @param pageSize
     * @param search
     */
    @Override
    public List<User> selectUserAll(int startIndex, int pageSize, String search) {
        String sql="select * from user where 1=1";
        StringBuilder builder = new StringBuilder(sql);
        if(search!=null&&!"".equals(search)){
            builder.append(" and username like '%"+search+"%'");
        }
        builder.append(" limit ?,?");
        List<User> userList=null;
        try {
            userList=queryRunner.query(builder.toString(),new BeanListHandler<>(User.class),startIndex,pageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    /**
     * 查询记录数
     * @return
     * @param search
     */
    @Override
    public int selectTotalCount(String search) {
        String sql="select count(*) from user where 1=1";
        StringBuilder builder = new StringBuilder(sql);
        if(search!=null&&!"".equals(search)){
            builder.append(" and username like '%"+search+"%'");
        }
        Long res=null;
        try {
            res=queryRunner.query(builder.toString(),new ScalarHandler<Long>());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res.intValue();
    }

    /**
     * 修改用户功能
     * @param user
     * @return
     */
    @Override
    public int updateUserByUid(User user) {
        String sql="update user set name=?,phone=?,age=?,sex=?,username=?,password=?,status=?,createtime=?,role=? where uid=?";
        Object[] obj={user.getName(),user.getPhone(),user.getAge(),user.getSex(),user.getUsername()
        ,user.getPassword(),user.getStatus(),user.getCreatetime(),user.getRole(),user.getUid()};
        int res=0;
        try {
            res=queryRunner.update(sql,obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public int deleteUser(int parseInt) {
        String sql="delete from user where uid=?";
        int res=0;
        try {
            res=queryRunner.update(sql,parseInt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    /**
     * 使用人名去查询数据库得到uid
     * @return
     * @param name
     */
    @Override
    public User selectUserByName(String name) {
        String sql="select * from user where name=?";
        User user=null;
        try {
            user=queryRunner.query(sql,new BeanHandler<>(User.class),name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    /**
     * 根据手机号查询用户
     * @param phone
     * @return
     */
    @Override
    public User selectByPhoneUser(String phone) {
        String sql="select * from user where phone = ?";
        User user=null;
        try {
           user= queryRunner.query(sql,new BeanHandler<>(User.class),phone);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    /**
     * 根据手机号和密码登录
     * @param phone
     * @param password
     * @return
     */
    @Override
    public User selectUserByPhoneAndPwd(String phone, String password) {
        String sql="select * from user where phone=? and password=?";
        Object[] objects={phone,password};
        User user=null;
        try {
            user=queryRunner.query(sql,new BeanHandler<>(User.class),objects);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
