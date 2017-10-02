/*
 * Copyright (c) 2014-2015, Yunnex and/or its affiliates. All rights reserved. Use, Copy is subject
 * to authorized license.
 */
package com.hoho.user.dto;

import java.util.Date;


/**
 * User Dto 对象
 * 
 * @author linxiang
 * @date 2017-04-17
 */
public class UserDto {

  /**
   * 序列化版本号
   */
  private static final long serialVersionUID = 1L;

  /**
   * 主键列 自增键
   */
  private Long id;

  /**
   * 
   * 用户名
   */
  private String username;

  /**
   * 
   * sex
   */
  private Boolean sex;

  /**
   * 
   * province
   */
  private String province;

  /**
   * 
   * city
   */
  private String city;

  /**
   * 
   * 邮箱
   */
  private String email;

  /**
   * 
   * 头像地址
   */
  private String headImgUrl;

  /**
   * 
   * 简介
   */
  private String remark;

  /**
   * 
   * 创建时间
   */
  private Date createTime;

  /**
   * 
   * updateTime
   */
  private Date updateTime;

  /**
   * 
   * 更新人
   */
  private String updatePerson;


  /**
   * 创建时间
   */
  private Date createTimeBegin;

  /**
   * 创建时间
   */
  private Date createTimeEnd;

  /**
   * updateTime
   */
  private Date updateTimeBegin;

  /**
   * updateTime
   */
  private Date updateTimeEnd;



  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return this.id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsername() {
    return this.username;
  }

  public void setSex(Boolean sex) {
    this.sex = sex;
  }

  public Boolean getSex() {
    return this.sex;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getProvince() {
    return this.province;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCity() {
    return this.city;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return this.email;
  }

  public void setHeadImgUrl(String headImgUrl) {
    this.headImgUrl = headImgUrl;
  }

  public String getHeadImgUrl() {
    return this.headImgUrl;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getRemark() {
    return this.remark;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getCreateTime() {
    return this.createTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Date getUpdateTime() {
    return this.updateTime;
  }

  public void setUpdatePerson(String updatePerson) {
    this.updatePerson = updatePerson;
  }

  public String getUpdatePerson() {
    return this.updatePerson;
  }


  public Date getCreateTimeBegin() {
    return this.createTimeBegin;
  }

  public void setCreateTimeBegin(Date createTimeBegin) {
    this.createTimeBegin = createTimeBegin;
  }

  public Date getCreateTimeEnd() {
    return this.createTimeEnd;
  }

  public void setCreateTimeEnd(Date createTimeEnd) {
    this.createTimeEnd = createTimeEnd;
  }

  public Date getUpdateTimeBegin() {
    return this.updateTimeBegin;
  }

  public void setUpdateTimeBegin(Date updateTimeBegin) {
    this.updateTimeBegin = updateTimeBegin;
  }

  public Date getUpdateTimeEnd() {
    return this.updateTimeEnd;
  }

  public void setUpdateTimeEnd(Date updateTimeEnd) {
    this.updateTimeEnd = updateTimeEnd;
  }

  @Override
  public String toString() {
    return "UserDto [id=" + id + ", username=" + username + ", sex=" + sex + ", province="
        + province + ", city=" + city + ", email=" + email + ", headImgUrl=" + headImgUrl
        + ", remark=" + remark + ", createTime=" + createTime + ", updateTime=" + updateTime
        + ", updatePerson=" + updatePerson + ", createTimeBegin=" + createTimeBegin
        + ", createTimeEnd=" + createTimeEnd + ", updateTimeBegin=" + updateTimeBegin
        + ", updateTimeEnd=" + updateTimeEnd + "]";
  }
}
