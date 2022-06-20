package com.offcn.service;

import com.offcn.bean.Course;
import com.offcn.bean.CourseUser;

import java.util.List;
import java.util.Map;

public interface UserCourseService {
    Map<String, Object> selectUserCourse(String search, int pageSize, String currentPage);

    int deleteCourseUser(String delarr);

    int updateUserCourse(String id, String name, String cid);

    int insertCourseUser(String uid, String cid);

    List<Course> selectCourseUserByuid(String uid);

    CourseUser isPayCourse(String uid, String cid);
}
