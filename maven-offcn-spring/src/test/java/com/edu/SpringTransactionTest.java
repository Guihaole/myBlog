package com.edu;

import com.edu.service.CountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:day05-tx-spring/applicationContext.xml")
public class SpringTransactionTest {
    @Autowired
    private CountService countService;
    @Test
    public void money()  {
        countService.moneyCount("machao","guihaole",1000.0);
    }
}
