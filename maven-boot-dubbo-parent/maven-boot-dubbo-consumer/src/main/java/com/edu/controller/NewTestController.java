package com.edu.controller;

import com.edu.service.SiteService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("version2")
@ResponseBody
public class NewTestController {
    //version: 是当服务接口提供者有多个以上我们可以指定固定版本名
    //interfaceName: 当服务接口提供者实现了多个，会生成多个SiteService类型的代理对象，指定具体的代理对象
    @Reference(version = "new", interfaceName = "newSiteServiceImpl")
    private SiteService siteService;

    //http://localhost:8080/version2/new/guihaole
    @GetMapping("/new/{name}")
    public String newVersion(@PathVariable("name") String name) {
        return siteService.getSiteById(name);
    }
}
