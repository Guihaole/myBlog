package com.edu.service.impl;

import com.edu.service.SiteService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class SiteServiceImpl implements SiteService {
    @Override
    public String getSiteById(String name) {
        return "hello boot:"+name;
    }
}
