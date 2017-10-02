/*
 * Copyright (c) 2014-2015, Yunnex and/or its affiliates. All rights reserved. Use, Copy is subject
 * to authorized license.
 */
package com.hoho.user.dao;

import com.hoho.user.entity.UserAccount;

/**
 * UserAccount Dao 接口
 * 
 * @author linxiang
 * @date 2017-04-17
 */
public interface UserAccountMapper {
  /** 根据主键查找 */
  int get(Object id);

  /** 保存 */
  int save(UserAccount userAccount);

  /** 更新操作 */
  int update(UserAccount userAccount);

  /** 删除 */
  int delete(Object id);
}
