package com.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {

    Map<String,Object> selectMapById(@Param("id") Long id);

    //按照自定义的条件分页
    Page<User> selectPageLimit(@Param("page") Page<User> page,@Param("age") Integer age);
}
