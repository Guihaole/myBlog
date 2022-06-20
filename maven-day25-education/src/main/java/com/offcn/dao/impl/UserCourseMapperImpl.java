package com.offcn.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.bean.Course;
import com.offcn.bean.CourseUser;
import com.offcn.bean.User;
import com.offcn.dao.UserCourseMapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserCourseMapperImpl implements UserCourseMapper {

    private QueryRunner queryRunner=new QueryRunner(new ComboPooledDataSource());
    /**
     * 查询模糊总条数+多表联合  or  子查询
     * @param search
     * @return
     */
    @Override
    public int totalCount(String search) {
        String sql="select uid from user where 1=1";
        StringBuilder builder = new StringBuilder(sql);
        if (search!=null&&!"".equals(search)) {
            builder.append(" and name like '%"+search+"%'");
        }
        String sql2="select count(*) from course_user where uid in ("+builder.toString()+")";
        Long res=null;
        try {
            res=queryRunner.query(sql2,new ScalarHandler<Long>());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res.intValue();
    }

    /**
     * 查询模糊带分页+多表联合
     * @param search
     * @param startIndex
     * @param pageSize
     * @return
     */
    @Override
    public List<CourseUser> selectUserCourse(String search, int startIndex, int pageSize) {
        String sql=" select t1.id,t0.cid,t0.courseName,t0.courseType,t0.coursePrice,t2.uid,t2.`name`,t2.phone from course t0,course_user t1,`user` t2 where t1.cid=t0.cid and t2.uid=t1.uid";
        StringBuilder builder = new StringBuilder(sql);
        if (search!=null&&!"".equals(search)) {
            builder.append(" and name like '%"+search+"%'");
        }
        builder.append(" limit ?,?");
        List<Map<String, Object>> query=null;
        try {
            query = queryRunner.query(builder.toString(), new MapListHandler(), startIndex, pageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<CourseUser> courseUserList = new ArrayList<>();
        for (Map<String, Object> map : query) {
            CourseUser courseUser = new CourseUser();
            courseUser.setId((Integer) map.get("id"));
            Course course=new Course((Integer) map.get("cid"),(String) map.get("courseName"),Double.parseDouble(map.get("coursePrice")+""),(Integer) map.get("courseType"));
            courseUser.setCourse(course);
            User user = new User((Integer)map.get("uid"),(String) map.get("name"),(String) map.get("phone"));
            courseUser.setUser(user);
            courseUserList.add(courseUser);
        }
        return courseUserList;
    }

    /**
     * 删除选中 使用in()
     * @param delarr
     * @return
     */
    @Override
    public int deleteCourseUser(String delarr) {
        String sql="delete from course_user where id in ("+delarr+")";
        int res=0;
        try {
            res=queryRunner.update(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    /**
     * 修改数据库
     * @param id
     * @param uid
     * @param cid
     * @return
     */
    @Override
    public int updateUserCourse(int id, int uid, int cid) {
        String sql="update course_user set uid=?,cid=? where id=?";
        int res=0;
        try {
            res=queryRunner.update(sql,uid,cid,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public int insertCourseUser(String uid, String cid) {
        String sql="insert into course_user (cid,uid) values (?,?)";
        int res=0;
        try {
            res=queryRunner.update(sql,cid,uid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    /**
     * 根据uid查询所有的课程信息集合
     * @param uid
     * @return
     */
    @Override
    public List<Course> selectCourseUserByuid(String uid) {
        String sql="select * from course where cid in(select cid from course_user where uid = ?)";
        List<Course> courseList=null;
        try {
            courseList=queryRunner.query(sql,new BeanListHandler<>(Course.class),uid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return courseList;
    }

    /**
     * 根据uid,cid查询记录
     * @param uid
     * @param cid
     * @return
     */
    @Override
    public CourseUser isPayCourse(String uid, String cid) {
        String sql="select * from course_user where uid = ? and cid = ?";
        CourseUser courseUser=null;
        try {
            courseUser=queryRunner.query(sql,new BeanHandler<>(CourseUser.class),uid,cid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return courseUser;
    }
}
