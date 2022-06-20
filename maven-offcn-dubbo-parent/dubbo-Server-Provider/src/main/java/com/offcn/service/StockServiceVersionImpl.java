package com.offcn.service;

import com.api.service.StockService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "version-1")
public class StockServiceVersionImpl implements StockService {
    @Override
    public String hello(String message) {
        return "version-1"+message;
    }
}
