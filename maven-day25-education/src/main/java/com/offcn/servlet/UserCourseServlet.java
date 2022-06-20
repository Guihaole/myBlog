package com.offcn.servlet;

import cn.hutool.json.JSONUtil;
import com.offcn.bean.Course;
import com.offcn.bean.CourseUser;
import com.offcn.service.UserCourseService;
import com.offcn.service.impl.UserCourseServiceImpl;
import com.offcn.util.BaseServlet;
import com.offcn.vo.ResultVo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/usercourse")
public class UserCourseServlet extends BaseServlet {

    private UserCourseService userCourseService=new UserCourseServiceImpl();
    /**
     * http://localhost:6060/education/usercourse?method=selectUserCourse
     * @param request
     * @param response
     */
    private void selectUserCourse(HttpServletRequest request,HttpServletResponse response ) throws IOException {
        //模糊查询
        String search = request.getParameter("search");
        //默认查询---分页查询
        int pageSize=Integer.parseInt(request.getParameter("pageSize"));
        String currentPage=request.getParameter("currentPage");
        //调用业务层
        Map<String,Object> map=userCourseService.selectUserCourse(search,pageSize,currentPage);
        ResultVo vo=null;
        if (map.size()>0) {
            vo=new ResultVo(200,"查询成功",map);
        }else {
            vo=new ResultVo(500,"查询失败",null);
        }
        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }

    /**
     * 修改选课信息  http://localhost:6060/education/usercourse?method=updateUserCourse
     * @param request
     * @param response
     */
    private void updateUserCourse(HttpServletRequest request,HttpServletResponse response ) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String cid = request.getParameter("cid");
        int res=userCourseService.updateUserCourse(id,name,cid);
        ResultVo vo=null;
        if (res>0) {
            vo=new ResultVo(200,"修改成功",res);
        }else {
            vo=new ResultVo(500,"请输入正确的用户名",null);
        }
        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }
    /**
     * 删除选课信息  http://localhost:6060/education/usercourse?method=deleteCourseUser
     * @param request
     * @param response
     */
    private void deleteCourseUser(HttpServletRequest request,HttpServletResponse response ) throws IOException {
        String delarr = request.getParameter("delarr");
        int res=userCourseService.deleteCourseUser(delarr);
        ResultVo vo=null;
        if (res>0) {
            vo=new ResultVo(200,"删除成功",res);
        }else {
            vo=new ResultVo(500,"删除失败",null);
        }
        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }

    /**
     * 向买课表中添加一条数据 http://localhost:6060/education/usercourse?method=insertCourseUser
     * @param request
     * @param response
     * @throws IOException
     */
    private void insertCourseUser(HttpServletRequest request,HttpServletResponse response ) throws IOException {
        String uid = request.getParameter("uid");
        String cid = request.getParameter("cid");
        int res=userCourseService.insertCourseUser(uid,cid);
        ResultVo vo=null;
        if (res>0) {
           //response.sendRedirect("http://127.0.0.1:5500/html/%E5%B0%8Fu%E5%AD%A6%E4%B9%A0/pages/course.html");
            //response.sendRedirect("http://116.205.230.80:6060/offcn/html/%E5%B0%8Fu%E5%AD%A6%E4%B9%A0/pages/course.html");
            response.sendRedirect("http://192.168.64.128:8080/offcn/html/%E5%B0%8Fu%E5%AD%A6%E4%B9%A0/pages/course.html");
        }else {
            vo=new ResultVo(500,"新增失败",null);
        }
        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }

    /**
     * 根据用户id查询所有报名的课程 http://localhost:6060/education/usercourse?method=selectCourseUserByuid
     * @param request
     * @param response
     * @throws IOException
     */
    private void selectCourseUserByuid(HttpServletRequest request,HttpServletResponse response ) throws IOException {
        String uid = request.getParameter("uid");
        List<Course> courseList=userCourseService.selectCourseUserByuid(uid);
        ResultVo vo=new ResultVo(200,"查询成功",courseList);
        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }

    /**
     * 判断是否购买过次课程 http://localhost:6060/education/usercourse?method=isPayCourse
     * @param request
     * @param response
     * @throws IOException
     */
    private void isPayCourse(HttpServletRequest request,HttpServletResponse response ) throws IOException {
        String uid = request.getParameter("uid");
        String cid = request.getParameter("cid");
        CourseUser courseUser=userCourseService.isPayCourse(uid,cid);
        ResultVo vo=null;
        if (courseUser!=null) {
            vo=new ResultVo(200,"该用户买过次课程",courseUser);
        }else {
            vo=new ResultVo(500,"该用户没买过次课程",null);
        }

        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }

}
