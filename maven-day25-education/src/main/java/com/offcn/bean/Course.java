package com.offcn.bean;

import java.util.Date;

public class Course {
    private Integer cid;//课程编号
    private String courseName;//课程名称
    private String descs;//课程简介
    private Integer courseType;//课程类型 1代表javaee  2代表数据库  3代表前端技术
    private String courseImage;//课程图片地址
    private String courseVideo;//课程视频地址
    private Double coursePrice;//价格
    private Integer status;//状态 0未上架  1代表上架   2代表下架
    private String createTime;//上传时间
    private Coursedetail coursedetail;

    public Coursedetail getCoursedetail() {
        return coursedetail;
    }

    public void setCoursedetail(Coursedetail coursedetail) {
        this.coursedetail = coursedetail;
    }

    public Course(Integer cid, String courseName, String descs, Integer courseType, String courseImage, String courseVideo, Double coursePrice, Integer status, String createTime, Coursedetail coursedetail) {
        this.cid = cid;
        this.courseName = courseName;
        this.descs = descs;
        this.courseType = courseType;
        this.courseImage = courseImage;
        this.courseVideo = courseVideo;
        this.coursePrice = coursePrice;
        this.status = status;
        this.createTime = createTime;
        this.coursedetail = coursedetail;
    }

    public Course(Integer cid, String courseName, Double coursePrice, Integer courseType) {
        this.cid = cid;
        this.courseName = courseName;
        this.coursePrice = coursePrice;
        this.courseType=courseType;
    }

    public Course() {
    }

    public Course(String courseName, String descs, Integer courseType, String courseImage, String courseVideo, Double coursePrice, Integer status, String createTime) {
        this.courseName = courseName;
        this.descs = descs;
        this.courseType = courseType;
        this.courseImage = courseImage;
        this.courseVideo = courseVideo;
        this.coursePrice = coursePrice;
        this.status = status;
        this.createTime = createTime;
    }

    public Course(Integer cid, String courseName, String descs, Integer courseType, String courseImage, String courseVideo, Double coursePrice, Integer status, String createTime) {
        this.cid = cid;
        this.courseName = courseName;
        this.descs = descs;
        this.courseType = courseType;
        this.courseImage = courseImage;
        this.courseVideo = courseVideo;
        this.coursePrice = coursePrice;
        this.status = status;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", courseName='" + courseName + '\'' +
                ", descs='" + descs + '\'' +
                ", courseType=" + courseType +
                ", courseImage='" + courseImage + '\'' +
                ", courseVideo='" + courseVideo + '\'' +
                ", coursePrice=" + coursePrice +
                ", status=" + status +
                ", createTime='" + createTime + '\'' +
                ", coursedetail=" + coursedetail +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public String getCourseVideo() {
        return courseVideo;
    }

    public void setCourseVideo(String courseVideo) {
        this.courseVideo = courseVideo;
    }

    public Double getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(Double coursePrice) {
        this.coursePrice = coursePrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
