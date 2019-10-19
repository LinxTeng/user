package com.linx.test.aop;

import org.springframework.aop.framework.AopContext;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.stereotype.Component;
import com.linx.test.javaconfig.MyService;

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

  public void say(String aa) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println(aa);
  }

  public void avage(Integer... aa) {
    Integer sum = 0;
    for (Integer a : aa) {
      sum += a;
    }
    System.out.println("总数" + sum);
  }

  public void myCeption() throws Exception {
    throw new Exception("我出错了");
  }

  public void foo() {
    ((Target) AopContext.currentProxy()).say("你好");
    // this.say("你好");
  }

  public static void main(String[] args) {
    Target target = new Target();
    // 代理
    ProxyFactory di = new ProxyFactory();
    di.addAdvice(new LoggerExecute());
    di.setTarget(target);
    di.setExposeProxy(true);
    Target proxy = (Target) di.getProxy();
    // proxy.execute();
    // proxy.execute2();
    proxy.foo();
  }
}
