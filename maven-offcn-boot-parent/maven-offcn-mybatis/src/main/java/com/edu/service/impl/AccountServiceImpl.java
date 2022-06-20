package com.edu.service.impl;

import com.edu.bean.Account;
import com.edu.mapper.AccountMapper;
import com.edu.service.AccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public PageInfo<Account> selectAccountList(Integer pageNo) {
        PageHelper.startPage(pageNo,2);
        List<Account> accountList = accountMapper.selectAccountList();
        PageInfo<Account> pageInfo = new PageInfo<>(accountList);
        return pageInfo;
    }

    @Override
    public Account selectAccountById(Integer id) {
        return accountMapper.selectAccountById(id);
    }
}
