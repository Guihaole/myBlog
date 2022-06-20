package com.edu.controller;

import com.edu.service.SiteService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("version1")
@ResponseBody
public class DefaultTestController {
    @Reference(version = "default",interfaceName = "defaultSiteServiceImpl")
    private SiteService siteService;
    //http://localhost:8080/version1/default/guihaole
    @GetMapping("/default/{name}")
    public String defaultVersion(@PathVariable("name") String name){
        return siteService.getSiteById(name);
    }
}
