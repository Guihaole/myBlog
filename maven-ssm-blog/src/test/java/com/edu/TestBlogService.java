package com.edu;

import com.edu.bean.Blog;
import com.edu.service.BlogService;
import com.edu.service.BtypeService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-context-config.xml")
public class TestBlogService {
    @Autowired
    private BlogService blogService;
    @Autowired
    private BtypeService btypeService;
    @Test
    public void test(){
        PageInfo<Blog> infoBlog = blogService.getPageInfoBlog(1);
        if (infoBlog.getList()==null) {
            return;
        }else {
            infoBlog.getList().forEach(System.out::println);
        }
    }
    @Test
    public void test2(){
        PageInfo btypeList = btypeService.getPageInfoBtypeList(1);
        btypeList.getList().forEach(System.out::println);
    }
}
