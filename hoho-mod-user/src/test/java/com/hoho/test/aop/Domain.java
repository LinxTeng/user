package com.hoho.test.aop;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class Domain {

  public static void main(String[] args) {
    Domain domain = new Domain();
    domain.byXML();
  }

  public void byAnnotation() {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(BeanScan.class);
    // context.getBeanFactory().registerSingleton("target", new Target());

    // Target aa = new Target();
    // aa.say("s123");
    // 必须通过bean注入实现
    Target target = context.getBean(Target.class);
    target.myExecute();
    target.myExecute();
    target.say("我要说");
    target.avage(1, 2, 3, 4);
  }

  public void byXML() {
    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("classpath*:/spring/testApplicationContext2.xml");
    Target target = context.getBean(Target.class);
    // target.myExecute();
    while (true) {
      target.say("我要说");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    // try {
    // target.myCeption();
    // } catch (Exception e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
  }

  public void byProxcy() {
    Target target = new Target();
    AspectJProxyFactory factory = new AspectJProxyFactory(target);
    factory.addAspect(ProfilingAspect.class);
    factory.setProxyTargetClass(true);
    Target targetProcy = factory.getProxy();
    targetProcy.say("holloe");
  }
}
