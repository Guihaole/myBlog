package com.edu;

import com.edu.bean.*;
import com.edu.mapper.BlogMapper;
import com.edu.mapper.BtypeMapper;
import com.edu.mapper.UserMapper;
import com.edu.service.EvaluateService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-context-config.xml")
public class TestMapper {
    @Autowired
    private EvaluateService evaluateService;
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private BtypeMapper btypeMapper;
    @Test
    public void test01(){
        PageInfo<Evaluate> pageInfoEvaluate = evaluateService.getPageInfoEvaluate(1, "a");
        if (pageInfoEvaluate!=null) {
            pageInfoEvaluate.getList().forEach(System.out::println);
        }
    }
    @Test
    public void  test02(){
        BlogExample blogExample = new BlogExample();
        blogExample.createCriteria().andBidEqualTo(1);
        Blog blog = blogMapper.getBlogAndEvaluateList(blogExample);
        System.out.println(blog);
    }
    @Test
    public void  test03(){
        BtypeExample btypeExample = new BtypeExample();
        btypeExample.createCriteria().andTypePidIsNull();
        List<Btype> btypeList = btypeMapper.selectBtypeList(btypeExample);
        btypeList.forEach(System.out::println);
    }
}
