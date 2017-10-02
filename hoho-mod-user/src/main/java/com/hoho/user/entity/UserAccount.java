/*
 * Copyright (c) 2014-2015, Yunnex and/or its affiliates. All rights reserved. Use, Copy is subject
 * to authorized license.
 */
package com.hoho.user.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * UserAccount 实体类
 * 
 * @author linxiang
 * @date 2017-04-17
 */
public class UserAccount {

  /**
   * 序列化版本号
   */
  private static final long serialVersionUID = 1L;

  /**
   * 主键列 自增健
   */
  private Long id;

  /**
   * 
   * 用户名
   */
  private String username;

  /**
   * 
   * 用户密码
   */
  private String password;

  /**
   * 
   * 用户id
   */
  private Integer userId;

  /**
   * 
   * 角色id
   */
  private String roleId;

  /**
   * 
   * createTime
   */
  private Date createTime;

  /**
   * 
   * updateTime
   */
  private Date updateTime;


  private List<User> users = new ArrayList<User>();


  public UserAccount() {
    // default constructor
  }

  public UserAccount(Long id) {
    this.id = id;
  }

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

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return this.password;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getUserId() {
    return this.userId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getRoleId() {
    return this.roleId;
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



  public void setUsers(List<User> users) {
    this.users = users;
  }

  public List<User> getUsers() {
    return users;
  }

}
