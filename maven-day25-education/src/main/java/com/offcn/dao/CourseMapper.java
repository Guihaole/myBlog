package com.offcn.dao;

import com.offcn.bean.Course;
import com.offcn.bean.Coursedetail;

import java.util.List;
import java.util.Map;

public interface CourseMapper {
    int addCourse(Course course);


    int selectTotalCount(String search,String courseType);

    List<Course> selectCourse(int startIndex, int pageSize, String search,String courseType);

    int updateCourse(Course course);

    int deleteCourseById(int i);

    int addCourseDetail(Coursedetail coursedetail);

    Course selectCourseByCid(Integer cid);

    List<Course> selectCourseNames();

    List<Course> selectCourseByType(int i);

    Map<String, List<Coursedetail>> mapDataCourseDetail(String cid);
}
