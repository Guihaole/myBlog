package com.edu.controller;

import com.edu.service.SiteService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/dubbo")
public class DubboTestController {
    @Reference(interfaceName = "siteServiceImpl")
    private SiteService siteService;
    //http://localhost:8080/dubbo/register/guihaole
    @GetMapping("/register/{name}")
    public String registerCenter(@PathVariable("name") String name) {
        return siteService.getSiteById(name);
    }
}
