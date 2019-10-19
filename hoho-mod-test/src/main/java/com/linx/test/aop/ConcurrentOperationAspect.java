package com.linx.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
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
  @Pointcut("execution(* com.linx.test.aop.Target.*(..))")
  private void anTargetExecute() {};

  // 定义切入点：所有public的方法
  @Pointcut("execution(public * *(..))")
  private void anyExecute() {};

  // 定义切入点：所有带有@MyService的方法
  @Pointcut("@annotation(com.linx.test.javaconfig.MyService)")
  private void anyMyService() {};

  // 定义切入点：所有带有@Compolent类的方法
  @Pointcut("@target(org.springframework.stereotype.Component)")
  private void anyComponent() {};

  @Around("com.linx.test.aop.ConcurrentOperationAspect.anyComponent()")
  public Object doConcurrentOperation(ProceedingJoinPoint pjp) throws Throwable {
    System.out.println("start");
    Object aa = pjp.proceed();
    return aa;
  }

  @Before("com.linx.test.aop.ConcurrentOperationAspect.anyComponent()")
  public void before() {
    System.out.println("before234");
  }


  // @Pointcut("execution(* Target.say(..))")
  // public void sayString() {};

  @Pointcut("execution(* com.linx.test.aop.Target.say(..)) && args(say,..)")
  public void combSayString(String say) {};


  @After("com.linx.test.aop.ConcurrentOperationAspect.combSayString(say)")
  public void afterSayString(String say) {
    System.out.println("拦截后要说的是：" + say);
  }

  // 或者直接在通知里面定义切点
  @Before("execution(* com.linx.test.aop.Target.say(..)) && args(say,..)")
  public void beforeSayString(String say) {
    System.out.println("拦截前要说的是：" + say);
  }

  // 或者around通知
  @Around("execution(* com.linx.test.aop.Target.say(..)) && args(say,..)")
  public Object doBasicProfiling(ProceedingJoinPoint pjp, String say) throws Throwable {
    System.out.println("拦截中要说的是：" + say);
    Object retVal = pjp.proceed();
    System.out.println("拦截中要说的是：" + say);
    return retVal;
  }

  // 引入
  @DeclareParents(value = "com.hoho.test.aop.*+", defaultImpl = DefaultUsageTracked.class)
  public static UsageTracked mixin;

  @Before("com.linx.test.aop.ConcurrentOperationAspect.anTargetExecute() && this(usageTracked)")
  public void recordUsage(UsageTracked usageTracked) {
    usageTracked.incrementUseCount();
  }

}
