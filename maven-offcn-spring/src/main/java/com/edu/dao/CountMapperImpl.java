package com.edu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class CountMapperImpl implements CountMapper{

    @Resource
    private JdbcTemplate jdbcTemplate;

    //转账dao
    @Override
    public int incrMoney(String name,Double money) {
        String sql="update count set money = money + ? where name = ?";
        int update = jdbcTemplate.update(sql, money, name);
        return update;
    }

    @Override
    public int decrMoney(String name,Double money) {
        String sql="update count set money = money - ? where name = ?";
        int update=jdbcTemplate.update(sql,money,name);
        return update;
    }
}
