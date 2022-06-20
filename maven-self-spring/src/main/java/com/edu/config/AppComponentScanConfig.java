package com.edu.config;

import com.edu.service.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@ComponentScan("com.edu.bean")
@ComponentScan(
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = UserService.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION,value=Component.class)
        }
)
public class AppComponentScanConfig {
}
