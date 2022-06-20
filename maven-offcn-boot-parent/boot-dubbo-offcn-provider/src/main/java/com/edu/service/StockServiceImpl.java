package com.edu.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.edu.StockService;
import com.edu.bean.Account;
import com.edu.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockMapper stockMapper;
    @Override
    public List<Account> AccountList() {
        return stockMapper.AccountList();
    }
}
