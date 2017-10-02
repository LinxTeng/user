/*
 * Copyright (c) 2014-2015, Yunnex and/or its affiliates. All rights reserved. Use, Copy is subject
 * to authorized license.
 */
package com.hoho.user.service;

import com.hoho.user.dto.UserDto;

/**
 * User Service
 * 
 * @author linxiang
 * @date 2017-04-17
 */
public interface UserService {
  /** 根据主键查找 */
  UserDto get(Object id);

  /** 用jdbc查询 */
  UserDto getUseJdbc(Long id);

  /** 保存 */
  UserDto save(UserDto user);

  /** 更新操作 */
  int update(UserDto user);

  /** 删除 */
  int delete(Object id);
}
