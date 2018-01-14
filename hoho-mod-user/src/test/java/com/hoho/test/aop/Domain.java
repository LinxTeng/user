package com.hoho.test.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class Domain {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(BeanScan.class);
    // context.getBeanFactory().registerSingleton("target", new Target());
    Target target = context.getBean(Target.class);
    target.myExecute();
    target.myExecute();
  }

}
