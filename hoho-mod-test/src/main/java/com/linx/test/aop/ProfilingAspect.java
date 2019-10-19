package com.linx.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

@Aspect
public class ProfilingAspect {

  @Around("methodToBeProfiled()")
  public Object profile(ProceedingJoinPoint pjp) throws Throwable {
    StopWatch sw = new StopWatch(this.getClass().getSimpleName());
    try {
      sw.start(pjp.getSignature().getName());
      return pjp.proceed();
    } finally {
      sw.stop();
      System.out.println(sw.prettyPrint());
    }
  }

  @Pointcut("execution(* com.linx.test.aop.Target.*(..))")
  public void methodToBeProfiled() {};
}
