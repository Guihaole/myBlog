package com.offcn.service.impl;

import com.offcn.bean.Course;
import com.offcn.bean.Coursedetail;
import com.offcn.dao.CourseMapper;
import com.offcn.dao.impl.CourseMapperImpl;
import com.offcn.service.CourseService;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class CourseServiceImpl implements CourseService {
    private CourseMapper courseMapper=new CourseMapperImpl();

    @Override
    public int addCourse(Course course) {

        return courseMapper.addCourse(course);
    }

    @Override
    public List<Course> selectCourse(int startIndex, int pageSize, String search,String courseType) {
        return courseMapper.selectCourse(startIndex,pageSize,search, courseType);
    }

    @Override
    public int selectTotalCount(String search,String courseType) {
        return courseMapper.selectTotalCount(search,courseType);
    }

    @Override
    public int updateCourse(Course course, String imageUrl, String vedioUrl) {
        //修改之前要将图片和视频删除
        //1.先查询数据库 根据cid
        Integer cid = course.getCid();
        Course courseSelect=courseMapper.selectCourseByCid(cid);
        String[] spliturl = imageUrl.split("/");
        String[] vediosplit = vedioUrl.split("/");
        imageUrl=spliturl[spliturl.length-1];
        vedioUrl=vediosplit[vediosplit.length-1];
        //判断删除谁
        if(!courseSelect.getCourseImage().equals(imageUrl)){
            File file = new File("E:\\photo\\"+courseSelect.getCourseImage());
            if (file.exists()) {
                file.delete();
            }
        }
        if (!courseSelect.getCourseVideo().equals(vedioUrl)) {
            File file = new File("E:\\photo\\"+courseSelect.getCourseVideo());
            if (file.exists()) {
                file.delete();
            }
        }
        course.setCourseImage(imageUrl);
        course.setCourseVideo(vedioUrl);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String createTime = simpleDateFormat.format(date);
        course.setCreateTime(createTime);

        return courseMapper.updateCourse(course);
    }

    @Override
    public int deleteChecked(String delarr) {
        String[] split = delarr.split(",");
        int res=0;
        for (String s : split) {
            res=res+courseMapper.deleteCourseById(Integer.parseInt(s));
        }
        return res;
    }

    @Override
    public Boolean addCourseDetail(Coursedetail coursedetail) {
        Boolean flag=false;
        String url = coursedetail.getUrl();
        String[] split = url.split("/");
        coursedetail.setUrl(split[split.length-1]);
        if("1".equals(coursedetail.getType())){
            coursedetail.setType("第一章");
        }else if("2".equals(coursedetail.getType())){
            coursedetail.setType("第二章");
        }else {
            coursedetail.setType("第三章");
        }
        int res=courseMapper.addCourseDetail(coursedetail);
        if(res>0){
            flag=true;
        }else {
            flag=false;
        }

        return flag;
    }

    @Override
    public List<Course> selectCourseNames() {
        return courseMapper.selectCourseNames();
    }

    @Override
    public List<Course> selectCourseByType(String courseType) {
        int i = Integer.parseInt(courseType);
        return courseMapper.selectCourseByType(i);
    }

    @Override
    public Course selectCourseByCid(String cid) {
        int i = Integer.parseInt(cid);
        return courseMapper.selectCourseByCid(i);
    }

    @Override
    public Map<String, List<Coursedetail>> mapDataCourseDetail(String cid) {
        return courseMapper.mapDataCourseDetail(cid);
    }
}
