package com.hoho.test.aop;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.stereotype.Component;
import com.hoho.test.javaconfig.MyService;

@Component
public class Target {
  public void execute() {
    System.out.println("程序开始执行");
  }

  public void execute2() {
    System.out.println("execute2开始执行");
  }

  @MyService
  public void myExecute() {
    System.out.println("myExecute执行了");
  }


  public static void main(String[] args) {
    Target target = new Target();
    // 代理
    ProxyFactory di = new ProxyFactory();
    di.addAdvice(new LoggerExecute());
    di.setTarget(target);
    Target proxy = (Target) di.getProxy();
    proxy.execute();
    proxy.execute2();
  }
}
