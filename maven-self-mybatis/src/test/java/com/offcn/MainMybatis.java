package com.offcn;


import com.offcn.bean.CollectionDemo;
import com.offcn.bean.Course;
import com.offcn.bean.User;
import com.offcn.mapper.CourseMapper;
import com.offcn.mapper.UserMapper;
import com.offcn.util.myutil.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MainMybatis {

    @Test
    public  void  day04Test3(){
        SqlSession sqlSession=null;
        try {
            sqlSession= MyBatisUtils.getSqlSession();
            CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
            List<Course> courseList = courseMapper.selectCourseByCourseName("vue");
            courseList.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public  void  day04Test4(){
        SqlSession sqlSession=null;
        try {
            sqlSession= MyBatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(userMapper.selectUserByUserName("root"));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public  void  day04Test1(){
        SqlSession sqlSession=null;
        try {
            sqlSession= MyBatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //User user = new User();
            //user.setUid(1);
            //user.setName("张三3");
            //user.setName("gui");
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(6);
            List<User> userList = userMapper.selectUserByIds3(new CollectionDemo(list));
            userList.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }
    @Test
    public  void  day04Test2(){
        SqlSession sqlSession=null;
        try {
            sqlSession= MyBatisUtils.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setUid(40);
            user.setName("张三2");
            user.setPhone("66666666678");
            System.out.println(userMapper.updateUserByUid2(user));
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

//    @Test
//    public  void  day03Test1(){
//        SqlSession sqlSession=null;
//        try {
//            sqlSession= MyBatisUtils.getSqlSession();
//            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//            //List<User> userList = userMapper.likeQuery("张");
//            List<User> userList = userMapper.selectUser();
//            for (User user : userList) {
//                System.out.println(user);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            MyBatisUtils.closeSqlSession(sqlSession);
//        }
//    }
//    @Test
//    public  void  day03Test2(){
//        SqlSession sqlSession=null;
//        try {
//            sqlSession= MyBatisUtils.getSqlSession();
//            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//            //userMapper.updateQuery1("guidashen1",34);
//            //            User user = new User();
//            //            user.setName("guidashen2");
//            //            user.setUid(34);
//            //            userMapper.updateQuery2(user);
//            Map<String,Object> map=new HashMap<>();
//            map.put("name","guidashen3");
//            map.put("uid",34);
//            userMapper.updateQuery3(map);
//            sqlSession.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            sqlSession.rollback();
//        }finally {
//            MyBatisUtils.closeSqlSession(sqlSession);
//        }
//    }
//    @Test
//    public  void  day03Test3(){
//        SqlSession sqlSession=null;
//        try {
//            sqlSession= MyBatisUtils.getSqlSession();
//            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//            User user = new User();
//            user.setName("gui");
//            user.setPhone("1111111");
//            userMapper.insertUser(user);
//            sqlSession.commit();
//            System.out.println(user.getUid());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            MyBatisUtils.closeSqlSession(sqlSession);
//        }
//    }
}
