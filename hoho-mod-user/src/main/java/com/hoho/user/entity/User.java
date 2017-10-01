/*
 * Copyright (c) 2014-2015, Yunnex and/or its affiliates. All rights reserved. Use, Copy is subject
 * to authorized license.
 */
package com.hoho.user.entity;

import java.util.Date;

/**
 * User 实体类
 * 
 * @author linxiang
 * @date 2017-04-17
 */
public class User {

    /**
     * 序列化版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键列 自增键
     */
    private Integer id;

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



    private UserAccount userAccount;


    public User() {
        // default constructor
    }

    public User(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
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



    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }
}
