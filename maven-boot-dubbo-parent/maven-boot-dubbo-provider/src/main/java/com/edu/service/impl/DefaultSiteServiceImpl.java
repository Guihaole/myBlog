package com.edu.service.impl;

import com.edu.service.SiteService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "default")
public class DefaultSiteServiceImpl implements SiteService {
    @Override
    public String getSiteById(String name) {
        return "default: "+name;
    }
}
