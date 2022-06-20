package com.api.service;

import com.api.service.invation.SiteServiceListener;

public interface StockService {
    public String hello(String message);
    //回调⽅法
    default String hello(String name, String key, SiteServiceListener
            siteServiceListener){
        return null;
    }
}
