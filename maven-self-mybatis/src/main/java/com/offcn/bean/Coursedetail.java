package com.offcn.bean;


public class Coursedetail {

  private Integer id;
  private String name;
  private String type;
  private String url;
  private String start_data;
  private Integer cid;


  public Coursedetail() {
  }

  public Coursedetail(String name, String type, String url, String start_data, Integer cid) {
    this.name = name;
    this.type = type;
    this.url = url;
    this.start_data = start_data;
    this.cid = cid;
  }

  public Coursedetail(Integer id, String name, String type, String url, String start_data, Integer cid) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.url = url;
    this.start_data = start_data;
    this.cid = cid;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getStart_data() {
    return start_data;
  }

  public void setStart_data(String start_data) {
    this.start_data = start_data;
  }

  public Integer getCid() {
    return cid;
  }

  public void setCid(Integer cid) {
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


  @Override
  public String toString() {
    return "Coursedetail{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", type='" + type + '\'' +
            ", url='" + url + '\'' +
            ", start_data='" + start_data + '\'' +
            ", cid=" + cid +
            '}';
  }
}
