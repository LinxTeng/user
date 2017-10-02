package com.hoho.user.service.impl;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.hoho.user.TestBase;
import com.hoho.user.service.UserAccountService;

public class UserAccountServiceTest extends TestBase {
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  UserAccountService userAccountService;

  @Test
  public void aa() {
    String result = userAccountService.sayHollen();
    logger.info("结果为:{}", result);
  }
}
