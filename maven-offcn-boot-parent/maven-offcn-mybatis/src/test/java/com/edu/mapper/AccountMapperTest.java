package com.edu.mapper;

import com.edu.bean.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AccountMapperTest {
    @Autowired
    private AccountMapper accountMapper;
    @Test
    public void select(){
        List<Account> accountList = accountMapper.selectAccountList();
        accountList.forEach(System.out::println);
        Account account = accountMapper.selectAccountById(1);
        System.out.println(account);
    }
}
