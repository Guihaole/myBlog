package com.offcn.service;

import com.api.service.StockService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "version-2")
public class StockServiceTimeOutImpl implements StockService {
    @Value("${server.port}")
    private String port;
    @Override
    public String hello(String message) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "version-2 "+port+message;
    }
}
