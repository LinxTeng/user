/*
 * Copyright (c) 2014-2015, Yunnex and/or its affiliates. All rights reserved. Use, Copy is subject
 * to authorized license.
 */
package com.hoho.user.dao;

import com.hoho.user.entity.User;

/**
 * User Dao 接口
 * 
 * @author linxiang
 * @date 2017-04-17
 */
public interface UserMapper {
  /** 根据主键查找 */
  User get(Object id);

  /** 保存 */
  int save(User user);

  /** 更新操作 */
  int update(User user);

  /** 删除 */
  int delete(Object id);
}
