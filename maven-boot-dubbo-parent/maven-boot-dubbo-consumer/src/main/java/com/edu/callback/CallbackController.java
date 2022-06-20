package com.edu.callback;

import com.edu.service.SiteService;
import com.edu.service.invation.SiteServiceListenerImpl;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("callback")
public class CallbackController {

    @Reference(version = "callback",
               interfaceName = "callbackServiceImpl")
    private SiteService siteService;
    //http://localhost:8080/callback/call/guihaole
    @GetMapping("/call/{name}")
    public String callBackTest(@PathVariable("name") String name){
        return siteService.getSiteById(name,"c1",new SiteServiceListenerImpl());
    }
}
