package com.edu.service;

import com.edu.service.invation.SiteServiceListener;

import java.util.concurrent.CompletableFuture;

public interface SiteService {
    //同步调用方法
    String getSiteById(String name);
    //回调方法
    default String getSiteById(String name, String key, SiteServiceListener siteServiceListener){
        return null;
    };
    //异步调用方法
    default CompletableFuture<String> getSiteByIdAsync(String name){
        return null;
    }
}
