package com.hoho.user.BaseJavaConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaDomain {
  public static void main(final String[] args) throws Exception {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanScan.class);
    MyBean myBean = ctx.getBean(MyBean.class);
    System.out.println(myBean.sayWord());
  }
}
