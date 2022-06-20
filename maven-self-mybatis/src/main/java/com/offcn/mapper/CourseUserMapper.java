package com.offcn.mapper;

import com.offcn.bean.CourseUser;
import org.apache.ibatis.annotations.Param;

public interface CourseUserMapper {
    //根据uid查询couser选课
    public CourseUser selectCourseUserByUid(@Param("uid") Integer uid);
}
