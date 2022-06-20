package com.edu.timeout;

import com.edu.service.SiteService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("native")
public class StubDubboController {

    //stub： 本地存根，会在本服务器找一个SiteServiceStub的实现类去调用,
    //------ SiteServiceStub代理去调用远程，如果捕获到异常，返回一个托底数据
    @Reference(version = "timeout",
            interfaceName = "timeOutSiteServiceImpl",
            timeout = 1000,
            stub = "true")
    private SiteService siteService;

    //http://localhost:8080/native/stub/guihaole
    @ResponseBody
    @GetMapping("/stub/{name}")
    public String stubTest(@PathVariable("name") String name) {
        return siteService.getSiteById(name);
    }
}
