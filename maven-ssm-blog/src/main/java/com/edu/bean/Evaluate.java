package com.edu.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
@JsonIgnoreProperties(value = "handler")
public class Evaluate implements Serializable {
    private Integer eid;

    private String econtent;

    private Integer bFk;

    private Integer uFk;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date etime;
    private User user;
    private Blog blog;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEcontent() {
        return econtent;
    }

    public void setEcontent(String econtent) {
        this.econtent = econtent == null ? null : econtent.trim();
    }

    public Integer getbFk() {
        return bFk;
    }

    public void setbFk(Integer bFk) {
        this.bFk = bFk;
    }

    public Integer getuFk() {
        return uFk;
    }

    public void setuFk(Integer uFk) {
        this.uFk = uFk;
    }

    public Date getEtime() {
        return etime;
    }

    public void setEtime(Date etime) {
        this.etime = etime;
    }

    @Override
    public String toString() {
        return "Evaluate{" +
                "eid=" + eid +
                ", econtent='" + econtent + '\'' +
                ", bFk=" + bFk +
                ", uFk=" + uFk +
                ", etime=" + etime +
                ", user=" + user +
                ", blog=" + blog +
                '}';
    }
}
