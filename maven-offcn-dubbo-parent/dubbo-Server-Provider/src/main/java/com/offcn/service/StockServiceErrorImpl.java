package com.offcn.service;

import com.api.service.StockService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "version-error")
public class StockServiceErrorImpl implements StockService {
    @Value("${server.port}")
    private String port;
    @Override
    public String hello(String message) {
        int a=10/0;
        return "version-error "+port+message;
    }
}
