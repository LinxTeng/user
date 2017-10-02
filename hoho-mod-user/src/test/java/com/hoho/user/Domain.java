package com.hoho.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.hoho.user.service.UserAccountService;

public class Domain {
  public static void main(final String[] args) throws Exception {
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/applicationContext.xml");
    UserAccountService messenger = (UserAccountService) ctx.getBean("userAccountService");
    System.out.println(messenger.sayHollen());
  }
}
