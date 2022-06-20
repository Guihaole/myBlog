package com.offcn.servlet;

import cn.hutool.json.JSONUtil;
import com.offcn.bean.Course;
import com.offcn.bean.Coursedetail;
import com.offcn.service.CourseService;
import com.offcn.service.impl.CourseServiceImpl;
import com.offcn.util.BaseServlet;
import com.offcn.util.DeleteUtils;
import com.offcn.util.PageUtils;
import com.offcn.util.UploadUtis;
import com.offcn.vo.ResultVo;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.*;
//  /software/tomcat6060/apache-tomcat-9.0.56/webapps/photo
@MultipartConfig
@WebServlet("/course")
public class CourseServlet extends BaseServlet {
    private CourseService courseService=new CourseServiceImpl();
    /**
     * 上传文件:  http://localhost:6060/education/course?method=uploadFile
     * @param request
     * @param response
     */
    private void uploadFile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Part part = request.getPart("file");
        String filename = UploadUtis.upload(part);
        //String url="http://localhost:6060/photo/"+filename;
        //String url="http://116.205.230.80:6060/photo/"+filename;
        String url="http://192.168.64.128:8080/photo/"+filename;
        ResultVo vo=null;
        if(!filename.contains(".mp4")){
            vo=new ResultVo(201,"上传图片成功",url);
        }else {
            vo=new ResultVo(200,"上传视频成功",url);
        }
        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }

    /**
     * 删除图片功能
     * http://localhost:6060/education/course?method=deleteFile
     * @param request
     * @param response
     */
    private void deleteFile(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String fileName = request.getParameter("fileName");
        String imageUrl = request.getParameter("imageUrl");
        String videoUrl = request.getParameter("videoUrl");
        //判断fileName是那个url
        ResultVo vo=null;
        if (imageUrl.contains(fileName)) {
            //是图片
            DeleteUtils.deleteFile(imageUrl);
            vo=new ResultVo(200,"删除图片成功","image");
        }else {
            DeleteUtils.deleteFile(videoUrl);
            //是videoUrl
            vo=new ResultVo(200,"删除视频成功","video");
        }
        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }

    /**
     * http://localhost:6060/education/course?method=addCourse
     * 添加课程信息到数据库
     * @param request
     * @param response
     */
    public void addCourse(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String courseName = request.getParameter("courseName");
        String descs = request.getParameter("descs");
        String courseType = request.getParameter("courseType");
        String imageUrl = request.getParameter("imageUrl");
        String vedioUrl = request.getParameter("vedioUrl");
        String coursePrice = request.getParameter("coursePrice");
        String status = request.getParameter("status");
        String[] spliturl = imageUrl.split("/");
        String[] vediosplit = vedioUrl.split("/");
        imageUrl=spliturl[spliturl.length-1];
        vedioUrl=vediosplit[vediosplit.length-1];
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String createTime = simpleDateFormat.format(date);
        Course course = new Course(courseName,descs,Integer.parseInt(courseType)
        ,imageUrl,vedioUrl,Double.parseDouble(coursePrice),Integer.parseInt(status),createTime);
        //业务处理
        int res=courseService.addCourse(course);
        ResultVo vo=null;
        if (res>0) {
            vo=new ResultVo(200,"添加成功",res);
        }else {
            vo=new ResultVo(500,"添加失败",res);
        }
        response.getWriter().write(JSONUtil.toJsonStr(vo));

    }

    /**
     * 修改课程  http://localhost:6060/education/course?method=updateCourse
     * @param request
     * @param response
     */
    private  void updateCourse(HttpServletRequest request,HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Course course = new Course();
        BeanUtils.populate(course,parameterMap);
        String imageUrl = request.getParameter("imageUrl");
        String vedioUrl = request.getParameter("vedioUrl");
        int res=courseService.updateCourse(course,imageUrl,vedioUrl);
        ResultVo vo=null;
        if (res>0) {
            vo=new ResultVo(200,"修改成功",res);
        }else {
            vo=new ResultVo(500,"修改失败",res);
        }
        response.getWriter().write(JSONUtil.toJsonStr(vo));

    }
    /**
     * 查询课程信息---查询所有 http://localhost:6060/education/course?method=selectCourse
     * 分页查询----页容量,当前页,总条数
     * @param request
     * @param response
     */
    public void selectCourse(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //模糊查询
        String search = request.getParameter("search");
        String currentPage=request.getParameter("currentPage");
        //带课程类型的分页
        String courseType = request.getParameter("courseType");

        Integer pageSize=Integer.parseInt(request.getParameter("pageSize"));
        //查询总条数
        int  totalCount= courseService.selectTotalCount(search,courseType);

        PageUtils pageUtils = new PageUtils(pageSize,totalCount,currentPage);
        //数据处理
        List<Course> courseList=courseService.selectCourse(pageUtils.getStartIndex(),pageUtils.getPageSize(),search,courseType);
        ResultVo vo=null;
        Map<String,Object> map=new HashMap<>();
        map.put("pageUtils",pageUtils);
        map.put("courseList",courseList);
        if (courseList==null) {
            vo=new ResultVo(201,"暂时还没有课程",null);
        }else {
            vo=new ResultVo(200,"查询成功",map);
        }
        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }

    /**
     * 删除选中的数据 http://localhost:6060/education/course?method=deleteChecked
     * @param request
     * @param response
     */
    private void deleteChecked(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String delarr = request.getParameter("delarr");
        //业务处理
        int res=courseService.deleteChecked(delarr);
        ResultVo vo=null;
        if (res>0) {
            vo=new ResultVo(200,"修改成功",res);
        }else {
            vo=new ResultVo(500,"修改失败",res);
        }
        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }

    /**
     * 删除图片和视频接口  http://localhost:6060/education/course?method=deleteFileVideoAndUrl
     * @param request
     * @param response
     */
    private void deleteFileVideoAndUrl(HttpServletRequest request,HttpServletResponse response){
        String courseImage = request.getParameter("courseImage");
        String courseVideo = request.getParameter("courseVideo");
        //删除图片
        //String url="E:\\photo\\";
        //String url="/software/tomcat6060/apache-tomcat-9.0.56/webapps/photo/";
        String url="/software/tomcat/photo/";
        if(courseImage!=null&&!"".equals(courseImage)){
            File file = new File(url+courseImage);
            if (file.exists()) {
                file.delete();
            }
        }
        if(courseVideo!=null&&!"".equals(courseVideo)){
            File file = new File(url + courseVideo);
            if (file.exists()) {
                file.delete();
            }
        }

    }

    /**
     * 增加课程明细请求接口  http://localhost:6060/education/course?method=addCourseDetail
     * @param request
     * @param response
     */
    private void addCourseDetail(HttpServletRequest request,HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        String start_date = request.getParameter("start_date");
        Coursedetail coursedetail = new Coursedetail();
        BeanUtils.populate(coursedetail,map);
        coursedetail.setStart_data(start_date);
        //System.out.println(coursedetail);
        //调用业务逻辑
        Boolean flag=courseService.addCourseDetail(coursedetail);
        ResultVo vo=null;
        if(flag){
            vo=new ResultVo(200,"添加成功",null);
        }else {
            vo=new ResultVo(500,"添加失败",null);
        }
        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }

    /**
     *    http://localhost:6060/education/course?method=selectCourseNames
     * @param request
     * @param response
     */
    private void selectCourseNames(HttpServletRequest request,HttpServletResponse response) throws IOException {
        List<Course> courseList=courseService.selectCourseNames();
        ResultVo vo=new ResultVo(200,"查询成功",courseList);
        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }

    /**
     * 根据类型查询课程  http://localhost:6060/education/course?method=selectCourseByType
     * @param request
     * @param response
     * @throws IOException
     */
    private void selectCourseByType(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String courseType = request.getParameter("courseType");
        List<Course> courseList=courseService.selectCourseByType(courseType);
        ResultVo vo=new ResultVo(200,"查询成功",courseList);
        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }

    /**
     * 根据cid获取课程信息和开课时间   http://localhost:6060/education/course?method=selectCourseByCid
     * @param request
     * @param response
     * @throws IOException
     */
    private void selectCourseByCid(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String cid = request.getParameter("cid");
        Course course=courseService.selectCourseByCid(cid);
        ResultVo vo=null;
        if (course!=null) {
            vo=new ResultVo(200,"查询成功",course);
        }else {
            vo=new ResultVo(500,"查询失败",null);
        }
        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }

    /**
     * 查询课程对应的章节以及章节数组  http://localhost:6060/education/course?method=mapDataCourseDetail
     * @param request
     * @param response
     * @throws IOException
     */
    private void mapDataCourseDetail(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String cid = request.getParameter("cid");
        Map<String,List<Coursedetail>> map=courseService.mapDataCourseDetail(cid);
        ResultVo vo=new ResultVo(200,"查询成功",map);
        response.getWriter().write(JSONUtil.toJsonStr(vo));
    }
}
