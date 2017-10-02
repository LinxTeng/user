/*
 * Copyright (c) 2014-2015, Yunnex and/or its affiliates. All rights reserved. Use, Copy is subject
 * to authorized license.
 */
package com.hoho.user.service.impl;

import org.springframework.stereotype.Service;
import com.hoho.user.dto.UserAccountDto;
import com.hoho.user.service.UserAccountService;



/**
 * UserAccount Service实现
 * 
 * @author linxiang
 * @date 2017-04-17
 */
@Service("userAccountService")
public class UserAccountServiceImpl implements UserAccountService {

  @Override
  public String sayHollen() {
    return "欢迎来到spring的世界";
  }

  @Override
  public UserAccountDto get(Object id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public UserAccountDto save(UserAccountDto userAccount) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int update(UserAccountDto userAccount) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int delete(Object id) {
    // TODO Auto-generated method stub
    return 0;
  }

}
