package com.edu.mapper;

import com.edu.bean.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {
    public List<Account> selectAccountList();
    public Account selectAccountById(Integer id);
}
