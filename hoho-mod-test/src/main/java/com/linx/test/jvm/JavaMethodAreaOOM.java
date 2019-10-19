package com.linx.test.jvm;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class JavaMethodAreaOOM {
  /**
   * VM Argss:-XX:PermSize=10M -XX:MaxPermSize=10M <br>
   * 对于jdk8没有效果
   * 
   * @param args
   */
  public static void main(String[] args) {
    while (true) {
      Enhancer enhancer = new Enhancer();
      enhancer.setSuperclass(OOMObject.class);
      enhancer.setUseCache(false);
      enhancer.setCallback(new MethodInterceptor() {

        @Override
        public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3)
            throws Throwable {
          return arg3.invokeSuper(arg0, arg2);
        }
      });
      enhancer.create();
    }
  }

  static class OOMObject {
  }
}
