package com.edu.service.impl;

import com.edu.service.SiteService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "new")
public class NewSiteServiceImpl implements SiteService {
    @Override
    public String getSiteById(String name) {
        return "new-version:"+name;
    }
}
