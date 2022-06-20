package com.edu.service.impl;

import com.edu.service.SiteService;
import org.apache.dubbo.config.annotation.Service;
@Service(version = "timeout")
public class TimeOutSiteServiceImpl implements SiteService{
        @Override
        public String getSiteById(String name) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "timeout-service:"+name;
        }
}
