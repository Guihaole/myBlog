package com.edu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.edu.StockService;
import com.edu.bean.Account;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api(tags = "dubbo测试管理")
@RestController
@RequestMapping("/order")
public class OrderController {
    @Reference
    private StockService stockService;
    //http://localhost:9090/AccountList
    @ApiOperation(value = "查询提供者数据")
    @GetMapping("/AccountList")
    public List<Account> AccountList(){
        return stockService.AccountList();
    }
}
