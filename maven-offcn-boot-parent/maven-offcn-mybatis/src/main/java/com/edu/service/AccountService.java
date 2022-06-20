package com.edu.service;

import com.edu.bean.Account;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AccountService {
    public PageInfo<Account> selectAccountList(Integer pageNo);
    public Account selectAccountById(Integer id);
}
