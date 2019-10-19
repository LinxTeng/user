package com.linx.test.callback;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Domain {
  public static void main(final String[] args) throws Exception {
    AnnotationConfigApplicationContext ctx =
        new AnnotationConfigApplicationContext(MyAware.class, MyCallback.class);
    MyAware MyAware = ctx.getBean(MyAware.class);
    // 优雅关机
    ctx.registerShutdownHook();
  }
}
