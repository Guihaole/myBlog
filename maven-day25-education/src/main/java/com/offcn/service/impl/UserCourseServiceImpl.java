package com.offcn.service.impl;

import com.offcn.bean.Course;
import com.offcn.bean.CourseUser;
import com.offcn.bean.User;
import com.offcn.dao.UserCourseMapper;
import com.offcn.dao.UserMapper;
import com.offcn.dao.impl.UserCourseMapperImpl;
import com.offcn.dao.impl.UserMapperImpl;
import com.offcn.service.UserCourseService;
import com.offcn.util.PageUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserCourseServiceImpl implements UserCourseService {
    private UserCourseMapper userCourseMapper=new UserCourseMapperImpl();
    private UserMapper userMapper=new UserMapperImpl();
    /**
     * 做选课的分页查询
     * @param search
     * @param pageSize
     * @param currentPage
     * @return
     */
    @Override
    public Map<String, Object> selectUserCourse(String search, int pageSize, String currentPage) {
        //计算总条数
        int totalCount=userCourseMapper.totalCount(search);
        //分页
        PageUtils pageUtils = new PageUtils(pageSize,totalCount,currentPage);
        Map<String,Object> map=new HashMap<>();
        map.put("pageUtils",pageUtils);
        //查询数据
        List<CourseUser> courseUserList=userCourseMapper.selectUserCourse(search,pageUtils.getStartIndex(),pageSize);
        map.put("courseUserList",courseUserList);
        return map;
    }

    @Override
    public int deleteCourseUser(String delarr) {
        return userCourseMapper.deleteCourseUser(delarr);
    }

    /**
     *
     * @return
     * @param id
     * @param name
     * @param cid
     */
    @Override
    public int updateUserCourse(String id, String name, String cid) {
        //使用人名去查询数据库得到uid
        User user=userMapper.selectUserByName(name);
        int uid=0;
        int res=0;
        if(user!=null){
            uid = user.getUid();
            res=userCourseMapper.updateUserCourse(Integer.parseInt(id),uid,Integer.parseInt(cid));
        }
        return res;
    }

    /**
     * 支付回调接口向数据库添加数据
     * @param uid
     * @param cid
     * @return
     */
    @Override
    public int insertCourseUser(String uid, String cid) {
        return userCourseMapper.insertCourseUser(uid, cid);
    }

    @Override
    public List<Course> selectCourseUserByuid(String uid) {
        return userCourseMapper.selectCourseUserByuid(uid);
    }

    @Override
    public CourseUser isPayCourse(String uid, String cid) {
        return userCourseMapper.isPayCourse(uid,cid);
    }
}
