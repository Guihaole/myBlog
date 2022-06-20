package com.api.service.invation;

import java.io.Serializable;

public class SiteServiceListenerImpl implements SiteServiceListener, Serializable {
    @Override
    public void changed(String data) {
        System.out.println(data);
    }
}
