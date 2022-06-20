package com.edu.mapper;

import com.edu.bean.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface StockMapper {
    public List<Account> AccountList();
}
