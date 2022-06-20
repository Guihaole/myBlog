package com.offcn.mapper;

import com.offcn.bean.CollectionDemo;
import com.offcn.bean.User;
import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    //参数映射：原生映射  arg0,arg1，注解映射 @Param(""),@Param("")
    //map集合映射，对象参数绑定映射
    //public List<User> selectUser();
    //public int insertUser(User user);
    //public int insertUser2(Map<String,Object> map);
    //-------------------------day03--------------------
    public List<User> likeQuery(String name);

    //参数映射
    //默认参数映射
    public Integer updateQuery(String name, Integer uid);

    //注解映射
    public Integer updateQuery1(@Param("name") String name, @Param("uid") Integer uid);

    //实体类映射
    public Integer updateQuery2(User user);

    //map映射
    public Integer updateQuery3(Map<String, Object> map);

    public List<User> selectUser();

    public Integer insertUser(User user);

    //查询一个对象练习 <where></where>
    public List<User> selectUserByUidOrName(User user);

    //修改一个对象练习 <set></set>
    public int updateUserByUid(User user);

    //重新做上面两个方法练习 <trim></trim>
    public List<User> selectUserByUidOrName2(User user);

    public int updateUserByUid2(User user);

    //练习choose  只会命中一个条件，条件一旦命中，后面不在看
    public List<User> selectUserByUidName(User user);

    //练习foreach  map,数组，集合，对象---collection 写的是 map,array,list,对象属性名称
    public List<User> selectUserByIds(List<Integer> ids);
    public List<User> selectUserByIds2(int[] ids);
    public List<User> selectUserByIds3(CollectionDemo collectionDemo);
    //练习一对多的多表联合查询
    public List<User> selectUserAndCourseUserByUserName(@Param("username") String username);
    public User selectUserByUserName(@Param("username") String username);

}
