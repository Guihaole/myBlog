package com.edu.service.impl;

import com.edu.service.SiteService;
import org.apache.dubbo.config.annotation.Service;

import java.util.concurrent.CompletableFuture;

@Service(version = "async")
public class AsyncServiceImpl implements SiteService {
    @Override
    public String getSiteById(String name) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "async: 异步调用返回结果："+name;
    }

    @Override
    public CompletableFuture<String> getSiteByIdAsync(String name) {
        System.out.println("异步调用: "+name);
        return CompletableFuture.supplyAsync(()->getSiteById(name));
    }
}
