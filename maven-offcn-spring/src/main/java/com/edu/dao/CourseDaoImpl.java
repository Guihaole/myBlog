package com.edu.dao;

import com.edu.bean.Course;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CourseDaoImpl implements CourseDao{
    @Autowired
    private QueryRunner queryRunner;
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
//
//
//    @Override
//    public Course selectCourseById(Integer id) {
//        String sql="select cid,courseName,courseType,courseImage from course where cid = ? ";
//        Course course = jdbcTemplate.queryForObject(sql, new RowMapper<Course>() {
//            @Override
//            public Course mapRow(ResultSet resultSet, int i) throws SQLException {
//                Course course = new Course();
//                course.setCid(Integer.valueOf(resultSet.getString("cid")));
//                course.setCourseName(resultSet.getString("courseName"));
//                course.setCourseType(Integer.parseInt(resultSet.getString("courseType")));
//                course.setCourseImage(resultSet.getString("courseImage"));
//                return course;
//            }
//        }, id);
//        return course;
//    }
//
//    @Override
//    public List<Course> selectAll() {
//        String sql="select cid,courseName,courseType,courseImage from course";
//        List<Course> courseList = jdbcTemplate.query(sql, new RowMapper<Course>() {
//            @Override
//            public Course mapRow(ResultSet resultSet, int i) throws SQLException {
//                Course course = new Course();
//                course.setCid(Integer.valueOf(resultSet.getString("cid")));
//                course.setCourseName(resultSet.getString("courseName"));
//                course.setCourseType(Integer.parseInt(resultSet.getString("courseType")));
//                course.setCourseImage(resultSet.getString("courseImage"));
//                return course;
//            }
//        });
//        return courseList;
//    }

    @Override
    public Course selectCourseById2(Integer id) {
        String sql="select cid,courseName,courseType,courseImage from course where cid = ? ";
        Course course = null;
        try {
            course = queryRunner.query(sql, new BeanHandler<Course>(Course.class), id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return course;
    }
}
