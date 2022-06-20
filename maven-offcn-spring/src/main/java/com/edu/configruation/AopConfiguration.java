package com.edu.configruation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.edu"})
@EnableAspectJAutoProxy
public class AopConfiguration {
}
