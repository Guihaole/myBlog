package com.edu.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
@JsonIgnoreProperties(value = "handler")
public class Btype implements Serializable {
    private Integer typeid;

    private String typename;

    private Integer typePid;

    private String typedes;
    private List<Btype> btypeList;

    public List<Btype> getBtypeList() {
        return btypeList;
    }

    public void setBtypeList(List<Btype> btypeList) {
        this.btypeList = btypeList;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Integer getTypePid() {
        return typePid;
    }

    public void setTypePid(Integer typePid) {
        this.typePid = typePid;
    }

    public String getTypedes() {
        return typedes;
    }

    public void setTypedes(String typedes) {
        this.typedes = typedes == null ? null : typedes.trim();
    }

    @Override
    public String toString() {
        return "Btype{" +
                "typeid=" + typeid +
                ", typename='" + typename + '\'' +
                ", typePid=" + typePid +
                ", typedes='" + typedes + '\'' +
                ", btypeList=" + btypeList +
                '}';
    }
}
