package com.offcn.mapper;

import com.offcn.bean.Course;
import com.offcn.bean.Coursedetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CoursedetailMapper {
    //根据cid查询课程的详情
    public List<Coursedetail> selectCourseDetailByCid(@Param("cid") Integer cid);
    //注解开发
    @Select("select id,name,type,url,start_data,cid from coursedetail")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "type",property = "type"),
            @Result(column = "start_data",property = "startData"),
            @Result(column = "cid",property = "cid"),
    })
    public List<Coursedetail> select();
    //    @Select("select id,name,type,url,start_data,cid from coursedetail where cid=#{cid}")
    //    @Results({
    //            @Result(column = "id",property = "id"),
    //            @Result(column = "name",property = "name"),
    //            @Result(column = "type",property = "type"),
    //            @Result(column = "start_data",property = "startData"),
    //            @Result(column = "cid",property = "cid"),
    //            @Result(property = "course"
    //                   ,javaType = Course.class
    //                   ,one = @One(select = "com.offcn.bean.Course.CourseById")
    //                   ,column = "cid")
    //    })
    //    public Coursedetail select(Integer cid);
}
