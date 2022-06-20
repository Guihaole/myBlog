package com.edu.bean;


public class Coursedetail {

  private Integer id;
  private String name;
  private String type;
  private String url;
  private String startData;
  private Integer cid;

  public Coursedetail() {
  }

  @Override
  public String toString() {
    return "Coursedetail{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", type='" + type + '\'' +
            ", url='" + url + '\'' +
            ", startData='" + startData + '\'' +
            ", cid=" + cid +
            '}';
  }

  public Coursedetail(Integer id, String name, String type, String url, String startData, Integer cid) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.url = url;
    this.startData = startData;
    this.cid = cid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public String getStartData() {
    return startData;
  }

  public void setStartData(String startData) {
    this.startData = startData;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCid() {
    return cid;
  }

  public void setCid(Integer cid) {
    this.cid = cid;
  }
}
