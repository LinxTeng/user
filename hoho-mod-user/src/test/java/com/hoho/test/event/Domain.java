package com.hoho.test.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Domain {
  static Domain domain;

  static {
    domain = new Domain();
  }

  public static void main(final String[] args) throws Exception {
    domain.testEvent();
  }

  public void testEvent() {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanScan.class);
    EmailService email = ctx.getBean(EmailService.class);
    email.sendEmail("163.com", "holle world");

    // EmailService2 email2 = ctx.getBean(EmailService2.class);
    // email2.handleBlackListEvent(new BlackListEvent(email2, "163.com", "holle world"));

  }
}
