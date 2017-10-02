/*
 * Copyright (c) 2014-2015, Yunnex and/or its affiliates. All rights reserved. Use, Copy is subject
 * to authorized license.
 */
package com.hoho.user.service;

import com.hoho.user.dto.UserAccountDto;

/**
 * UserAccount Service
 * 
 * @author linxiang
 * @date 2017-04-17
 */
public interface UserAccountService {
  String sayHollen();

  /** 根据主键查找 */
  UserAccountDto get(Object id);

  /** 保存 */
  UserAccountDto save(UserAccountDto userAccount);

  /** 更新操作 */
  int update(UserAccountDto userAccount);

  /** 删除 */
  int delete(Object id);
}
