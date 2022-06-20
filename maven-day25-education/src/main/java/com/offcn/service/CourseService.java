package com.offcn.service;

import com.offcn.bean.Course;
import com.offcn.bean.Coursedetail;

import java.util.List;
import java.util.Map;

public interface CourseService {
    int addCourse(Course course);

    List<Course> selectCourse(int startIndex, int pageSize, String search,String courseType);

    int selectTotalCount(String search,String courseType);


    int updateCourse(Course course, String imageUrl, String vedioUrl);

    int deleteChecked(String delarr);

    Boolean addCourseDetail(Coursedetail coursedetail);

    List<Course> selectCourseNames();

    List<Course> selectCourseByType(String courseType);

    Course selectCourseByCid(String cid);

    Map<String, List<Coursedetail>> mapDataCourseDetail(String cid);
}
