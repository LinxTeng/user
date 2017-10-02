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
  public void testUseJdbc() {
    UserDto user = userService.getUseJdbc(3L);
    System.out.println("结果：" + user);
  }

  @Test
  public void testDelete() {
    int ok = userService.delete(3);
    System.out.println("删除结果" + ok);
  }
}
