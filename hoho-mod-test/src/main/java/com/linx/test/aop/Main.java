package com.linx.test.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) {
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("classpath*:/spring/testAspect.xml");
    Target target = new Target();
    target.say("hollo");
  }
  // Load Time Weaving
  // 需要添加-javaagent:D:\localRepository\org\springframework\spring-instrument\4.3.7.RELEASE\spring-instrument-4.3.7.RELEASE.jar
}
