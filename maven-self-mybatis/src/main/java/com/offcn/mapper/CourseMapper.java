package com.offcn.mapper;

import com.offcn.bean.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    //根据课程名查询所有课程和课程详情
    public List<Course> selectCourseAndDetailByCourseName(@Param("courseName") String courseName);
    //子查询
    public List<Course> selectCourseAndDetailByCourseName2(@Param("courseName") String courseName);
    //练习一对多的多表联合查询
    //课程和课程详情
    public List<Course> selectCourseAndDetailByCourseName3(@Param("courseName") String courseName);
    //根据课程名查询课程详情
    public  List<Course> selectCourseByCourseName(@Param("courseName") String courseName);
}
