package com.edu.service.impl;

import com.edu.service.SiteService;
import com.edu.service.invation.SiteServiceListener;
import org.apache.dubbo.config.annotation.Argument;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "callback",
        methods = {
            @Method(
                    name = "getSiteById",
                    arguments = {@Argument(index = 2,callback = true)}
            )
        },
        callbacks = 3)
public class CallbackServiceImpl implements SiteService {
    @Override
    public String getSiteById(String name) {
        return null;
    }

    @Override
    public String getSiteById(String name, String key, SiteServiceListener siteServiceListener) {
        siteServiceListener.changed(name);
        return "callback"+name;
    }
}
