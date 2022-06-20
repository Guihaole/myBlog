package com.edu.async;

import com.edu.service.SiteService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

@Controller
@ResponseBody
@RequestMapping("async")
public class AsyncTestController {
    @Reference(version = "async",
            interfaceName = "asyncServiceImpl"
            ,timeout = 5000)
    private SiteService siteService;
    //http://localhost:8080/async/test/guihaole
    @GetMapping("/test/{name}")
    public String asyncTest(@PathVariable("name")String name){
        CompletableFuture<String> siteByIdAsync = siteService.getSiteByIdAsync(name);
        siteByIdAsync.whenComplete(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable throwable) {
                if (s==null) {
                    throwable.printStackTrace();
                }else {
                    System.out.println(s);
                }
            }
        });
        return "异步调用还未响应，我先响应";
    }
}
