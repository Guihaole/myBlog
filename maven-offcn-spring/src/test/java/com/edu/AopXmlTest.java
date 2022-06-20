package com.edu;

import com.edu.service.AopServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:day06-aop-spring/bean-aop.xml")
public class AopXmlTest {
    @Autowired
    private AopServiceImpl aopService;
    @Test
    public void testAop(){
        aopService.aopAspect();
    }
}
