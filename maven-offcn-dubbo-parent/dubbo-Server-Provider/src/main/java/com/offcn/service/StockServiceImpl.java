package com.offcn.service;


import com.api.service.StockService;
import org.apache.dubbo.config.annotation.Service;


@Service(version = "version-rpc")
public class StockServiceImpl implements  StockService{

    @Override
    public String hello(String message) {
        return "hello "+message;
    }
}
