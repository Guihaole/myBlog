package com.edu.dao;

public interface CountMapper {
    public int incrMoney(String name,Double money);
    public int decrMoney(String name,Double money);
}
