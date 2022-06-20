package com.offcn.dao;

import com.offcn.bean.Course;
import com.offcn.bean.CourseUser;

import java.util.List;

public interface UserCourseMapper {
    int totalCount(String search);

    List<CourseUser> selectUserCourse(String search, int startIndex, int pageSize);

    int deleteCourseUser(String delarr);

    int updateUserCourse(int id, int uid, int cid);

    int insertCourseUser(String uid, String cid);

    List<Course> selectCourseUserByuid(String uid);

    CourseUser isPayCourse(String uid, String cid);
}
