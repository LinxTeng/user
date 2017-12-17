package com.hoho.test.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Domain {
  public static void main(final String[] args) throws Exception {
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("classpath*:/spring/testApplicationContext.xml");
    ChildrenClass messenger = (ChildrenClass) ctx.getBean("alichildrenClass");
    System.out.println(messenger.getName());
    System.out.println(messenger.getSex());
  }
}
