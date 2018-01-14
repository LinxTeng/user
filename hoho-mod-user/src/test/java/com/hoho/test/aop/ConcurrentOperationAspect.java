package com.hoho.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ConcurrentOperationAspect implements Ordered {
  @Override
  public int getOrder() {
    return 1;
  }

  // 定义切入点：所有my*的方法
  @Pointcut("execution(* my*(..))")
  private void anyMyExecute() {};

  // 定义切入点：所有execute的方法
  @Pointcut("execution(* com.hoho.test.aop.Target.*(..))")
  private void anTargetExecute() {};

  // 定义切入点：所有public的方法
  @Pointcut("execution(public * *(..))")
  private void anyExecute() {};

  // 定义切入点：所有带有@MyService的方法
  @Pointcut("@annotation(com.hoho.test.javaconfig.MyService)")
  private void anyMyService() {};

  // 定义切入点：所有带有@Compolent类的方法
  @Pointcut("@target(org.springframework.stereotype.Component)")
  private void anyComponent() {};

  @Around("com.hoho.test.aop.ConcurrentOperationAspect.anyComponent()")
  public Object doConcurrentOperation(ProceedingJoinPoint pjp) throws Throwable {
    System.out.println("start");
    Object aa = pjp.proceed();
    return aa;
  }

  @Before("com.hoho.test.aop.ConcurrentOperationAspect.anyComponent()")
  public void before() {
    System.out.println("before");
  }

}
