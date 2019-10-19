package com.linx.test.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggerExecute implements MethodInterceptor {

  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    System.out.println("我要开始执行某个方法了");
    invocation.proceed();
    System.out.println("方法已经执行完成了");
    return null;
  }


}
