package com.edu.controller;

import com.api.service.StockService;
import com.api.service.invation.SiteServiceListenerImpl;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
//    version-callback
    @Reference(version = "version-callback",timeout = 1000,
            mock = "fail:return timeout",loadbalance = "random"
            ,stub = "true")
    private StockService stockService;

    //http://localhost:8081/hello/{下单完成！库存扣减1}
    @GetMapping("/hello/{message}")
    public String hello(@PathVariable String message) {
        return stockService.hello(message,"c1",new SiteServiceListenerImpl());
    }
}
