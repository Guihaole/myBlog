package com.edu.service;

public class SiteServiceStub implements SiteService{
    private final SiteService siteService;

    public SiteServiceStub(SiteService siteService) {
        this.siteService = siteService;
    }

    @Override
    public String getSiteById(String name) {
        try {
            return siteService.getSiteById(name);
        } catch (Exception e) {
            return "stub: 调用本地存根："+name;
        }
    }
}
