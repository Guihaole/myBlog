package com.offcn.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.bean.Course;
import com.offcn.bean.Coursedetail;
import com.offcn.dao.CourseMapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseMapperImpl implements CourseMapper {
    private DataSource dataSource=new ComboPooledDataSource();
    private QueryRunner queryRunner=new QueryRunner(dataSource);
    /**
     * 添加课程
     * @param course
     * @return
     */
    @Override
    public int addCourse(Course course) {
        String sql="insert into course values(?,?,?,?,?,?,?,?,?)";
        int res=0;
        Object[] obj={null,course.getCourseName(),course.getDescs(),course.getCourseType(),course.getCourseImage()
        ,course.getCourseVideo(),course.getCoursePrice(),course.getStatus(),course.getCreateTime()};
        try {
            res=queryRunner.update(sql,obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }
    /**
     * 查询总条数
     * @return
     * @param search
     */
    @Override
    public int selectTotalCount(String search,String courseType) {
        String sql="select count(*) from course where 1=1";
        StringBuilder builder = new StringBuilder(sql);
        if (search!=null&&!"".equals(search)) {
            builder.append(" and courseName like '%"+search+"%'");
        }
        if (courseType!=null&&!"".equals(courseType)) {
            builder.append(" and courseType = "+courseType+"");
        }
        Long res=null;
        try {
            res=queryRunner.query(builder.toString(),new ScalarHandler<Long>());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res.intValue();
    }
    /**
     * 查询所有课程
     * @return
     */
    @Override
    public List<Course> selectCourse(int startIndex, int pageSize, String search,String courseType) {
        String sql="select * from course where 1=1";
        StringBuilder builder = new StringBuilder(sql);
        if (search!=null&&!"".equals(search)) {
            builder.append(" and courseName like '%"+search+"%'");
        }
        if (courseType!=null&&!"".equals(courseType)) {
            builder.append(" and courseType = "+courseType+"");
        }
        builder.append(" limit ?,?");
        List<Course> courseList=null;
        try {
            courseList=queryRunner.query(builder.toString(),new BeanListHandler<>(Course.class),startIndex,pageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return courseList;
    }

    /**
     * 更新课程
     * @return
     * @param course
     */
    @Override
    public int updateCourse(Course course) {
        String sql="update course set courseName=?,descs=?,courseType=?,courseImage=?,courseVideo=?,coursePrice=?,status=?,createTime=? where cid=?";
        Object[] obj={course.getCourseName(),course.getDescs(),course.getCourseType(),course.getCourseImage()
        ,course.getCourseVideo(),course.getCoursePrice(),course.getStatus(),course.getCreateTime(),course.getCid()};
        int res=0;
        try {
            res=queryRunner.update(sql,obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    /**
     * 根据id删除课程
     * @param i
     * @return
     */
    @Override
    public int deleteCourseById(int i) {
        String sql="delete from course where cid=?";
        int res=0;
        try {
            res=queryRunner.update(sql,i);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    /**
     * 添加课程明细
     * @param coursedetail
     * @return
     */
    @Override
    public int addCourseDetail(Coursedetail coursedetail) {
        String sql="insert into coursedetail values(?,?,?,?,?,?)";
        Object[] objects={null,coursedetail.getName(),coursedetail.getType(),coursedetail.getUrl()
        ,coursedetail.getStart_data(),coursedetail.getCid()};
        int res=0;
        try {
            res=queryRunner.update(sql,objects);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    /**
     * 根据cid查询课程
     * @param cid
     * @return
     */
    @Override
    public Course selectCourseByCid(Integer cid) {
        String sql="select * from course where cid = ?";
        String sql2="select * from coursedetail where cid=? limit 0,1";
        Course course=null;
        try {
            course=queryRunner.query(sql,new BeanHandler<>(Course.class),cid);
            Coursedetail query = queryRunner.query(sql2, new BeanHandler<>(Coursedetail.class), course.getCid());
            course.setCoursedetail(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return course;
    }

    @Override
    public List<Course> selectCourseNames() {
        String sql="select * from course";
        List<Course> courseList=null;
        try {
            courseList=queryRunner.query(sql,new BeanListHandler<>(Course.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return courseList;
    }

    /**
     * 根据类型查询课程
     * @return
     * @param i
     */
    @Override
    public List<Course> selectCourseByType(int i) {
        String sql="select * from course where courseType = ?";
        List<Course> courseList=null;
        try {
            courseList=queryRunner.query(sql,new BeanListHandler<>(Course.class),i);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return courseList;
    }

    /**
     * 根据cid查询课程对应的章节以及章节数组
     * @param cid
     * @return
     */
    @Override
    public Map<String, List<Coursedetail>> mapDataCourseDetail(String cid) {
        String sql="select DISTINCT type from coursedetail where cid = ?";
        String sqlList="select * from coursedetail where cid=? and type=?";
        //查询对应的章节
        List<Coursedetail> coursedetails=null;
        //放一个章节对应的数据
        List<Coursedetail> coursedetailList=null;
        Map<String, List<Coursedetail>> map=new HashMap<>();
        try {
            coursedetails=queryRunner.query(sql,new BeanListHandler<>(Coursedetail.class),cid);
            for (Coursedetail coursedetail : coursedetails) {
                coursedetailList=queryRunner.query(sqlList,new BeanListHandler<>(Coursedetail.class),cid,coursedetail.getType());
                map.put(coursedetail.getType(),coursedetailList);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return map;
    }
}
