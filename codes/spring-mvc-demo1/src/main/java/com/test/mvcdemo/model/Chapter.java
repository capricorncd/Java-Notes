package com.test.mvcdemo.model;

public class Chapter {
  private Integer id;
  private Integer courseId;
  private Integer order;
  private String title;
  private String desc;
  
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public Integer getCourseId() {
    return courseId;
  }
  
  public void setCourseId(Integer courseId) {
    this.courseId = courseId;
  }
  
  public Integer getOrder() {
    return order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }

  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getDesc() {
    return desc;
  }
  
  public void setDesc(String desc) {
    this.desc = desc;
  }
  
}
