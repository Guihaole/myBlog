package com.edu.mapper;

//整合mybatis用的案例
import com.edu.bean.Coursedetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseDetailMapper {
    public List<Coursedetail> selectAll();
    public Integer insertCourseDetail(Coursedetail coursedetail);
    public Integer deleteCourseDetailByIds(int[] ids);
    public Integer updateCourseDetailByIdAndName
            (@Param("id")Integer id,@Param("name") String name);
}
