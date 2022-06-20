package com.offcn.bean;

public class CourseUser {
    private Integer id;
    private Course course;
    private User user;
    private Integer cid;
    private Integer uid;


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public CourseUser() {
    }

    public CourseUser(Integer id, Course course, User user) {
        this.id = id;
        this.course = course;
        this.user = user;
    }

    public CourseUser(Course course, User user) {
        this.course = course;
        this.user = user;
    }

    @Override
    public String toString() {
        return "CourseUser{" +
                "id=" + id +
                ", course=" + course +
                ", user=" + user +
                ", cid=" + cid +
                ", uid=" + uid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
