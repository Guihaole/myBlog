package com.edu.service.impl;

import com.edu.service.SiteService;

public class SiteServiceImpl implements SiteService {
    @Override
    public String getName(String name) {
        return "name: "+name;
    }
}
