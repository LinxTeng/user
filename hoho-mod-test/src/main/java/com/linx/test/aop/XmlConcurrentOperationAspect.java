package com.linx.test.aop;

public class XmlConcurrentOperationAspect {
  public void before() {
    System.out.println("我要做一些事情");
  }

  public void myEception() {
    System.out.println("方法出错了，我做了一些事");
  }
}
