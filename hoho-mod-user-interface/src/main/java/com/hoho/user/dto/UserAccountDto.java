/*
 * Copyright (c) 2014-2015, Yunnex and/or its affiliates. All rights reserved. Use, Copy is subject
 * to authorized license.
 */
package com.hoho.user.dto;

import java.util.Date;


/**
 * UserAccount Dto 对象
 * 
 * @author linxiang
 * @date 2017-04-17
 */
public class UserAccountDto {

    /**
     * 序列化版本号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键列 自增健
     */
    private Integer id;

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


    /**
     * createTime
     */
    private Date createTimeBegin;

    /**
     * createTime
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


}
