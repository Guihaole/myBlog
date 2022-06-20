package com.edu.dao;

import com.edu.bean.Course;

import java.util.List;

public interface CourseDao {
    //根据id查询课程信息
//    public Course selectCourseById(Integer id);
//    //查询所有
//    public List<Course> selectAll();
    public Course selectCourseById2(Integer id);
}
