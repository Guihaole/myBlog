package com.offcn.service;

import com.api.service.StockService;
import com.api.service.invation.SiteServiceListener;
import org.apache.dubbo.config.annotation.Argument;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;

@Service(
        version = "version-callback",
        methods = {@Method(name = "hello",
        arguments = {@Argument(index = 1, callback = true)}
        )}
)
public class StockServiceInvationImpl implements StockService {
    @Override
    public String hello(String message) {
        return null;
    }
    //实现回调接口
    @Override
    public String hello(String name, String key, SiteServiceListener siteServiceListener) {
        siteServiceListener.changed("provider_anck");
        return "version-callback"+name;
    }
}
