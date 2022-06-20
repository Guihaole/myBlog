package com.edu;


import com.edu.bean.Coursedetail;
import com.edu.mapper.CourseDetailMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//测试mybatis-spring整合
@ContextConfiguration(locations = "classpath:day04-mybatis-spring/applicationContext.xml")
public class SpringMybatisConfigTest {
    @Autowired
    private CourseDetailMapper courseDetailMapper;
    @Test
    public void selectAll(){
        courseDetailMapper.selectAll().forEach(System.out::println);
    }
    @Test
    public void insertCourseDetail(){
        Coursedetail coursedetail=new Coursedetail();
        coursedetail.setName("hahhah2");
        coursedetail.setType("1");
        coursedetail.setUrl("http://www.baidu.com");
        courseDetailMapper.insertCourseDetail(coursedetail);
    }
    @Test
    public void deleteCourseDetailByIds(){
        courseDetailMapper.updateCourseDetailByIdAndName(28,"guihaole");
    }
    @Test
    public void updateCourseDetailByIdAndName(){
        courseDetailMapper.deleteCourseDetailByIds(new int[]{27,28});
    }


}
