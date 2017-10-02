package com.hoho.user.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.hoho.user.TestBase;
import com.hoho.user.dto.UserDto;
import com.hoho.user.service.UserService;

public class UserServiceTest extends TestBase {
  @Autowired
  UserService userService;

  @Test
  public void testGet() {
    UserDto user = userService.get(3L);
    System.out.println("结果：" + user);
  }

}
