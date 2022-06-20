package com.edu.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(value = "handler")
public class Blog implements Serializable {
    private Integer bid;

    private String btitle;

    private Integer typeFk;

    private Integer uFk;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String bcontent;
    private User user;
    private Btype btype;

    //查询一个博主的评论根据bid
    private List<Evaluate> evaluateList;

    public List<Evaluate> getEvaluateList() {
        return evaluateList;
    }

    public void setEvaluateList(List<Evaluate> evaluateList) {
        this.evaluateList = evaluateList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Btype getBtype() {
        return btype;
    }

    public void setBtype(Btype btype) {
        this.btype = btype;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle == null ? null : btitle.trim();
    }

    public Integer getTypeFk() {
        return typeFk;
    }

    public void setTypeFk(Integer typeFk) {
        this.typeFk = typeFk;
    }

    public Integer getuFk() {
        return uFk;
    }

    public void setuFk(Integer uFk) {
        this.uFk = uFk;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent == null ? null : bcontent.trim();
    }

    @Override
    public String toString() {
        return "Blog{" +
                "bid=" + bid +
                ", btitle='" + btitle + '\'' +
                ", typeFk=" + typeFk +
                ", uFk=" + uFk +
                ", date=" + date +
                ", bcontent='" + bcontent + '\'' +
                ", user=" + user +
                ", btype=" + btype +
                ", evaluateList=" + evaluateList +
                '}';
    }
}
