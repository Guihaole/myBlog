package com.edu.mapper;
import com.edu.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
//@Mapper也可以加这个注解，使mybatis可以找到位置映射
public interface UserMapper {
    public List<User> selectUserAll();
}
