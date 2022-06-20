package com.edu.bean;


import java.io.Serializable;

public class Course implements Serializable {

  private Integer cid;
  private String courseName;
  private String descs;
  private Integer courseType;
  private String courseImage;
  private String courseVideo;
  private Double coursePrice;
  private Double status;
  private String createTime;

  public Course() {
  }

  public Course(Integer cid, String courseName, String descs, Integer courseType, String courseImage, String courseVideo, Double coursePrice, Double status, String createTime) {
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

  public Double getStatus() {
    return status;
  }

  public void setStatus(Double status) {
    this.status = status;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }
}
