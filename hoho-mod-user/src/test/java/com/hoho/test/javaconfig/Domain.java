package com.hoho.test.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class Domain {
  public static void main(final String[] args) throws Exception {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    // 激活不同环境的配置信息。与@Profile配合
    ctx.getEnvironment().setActiveProfiles("test");
    ctx.register(BeanScan.class);
    ctx.refresh();

    // 如果只加载bean则可以直接加载MyBeanfactory.class
    /*
     * AnnotationConfigApplicationContext ctx =new
     * AnnotationConfigApplicationContext(MyBeanfactory.class);
     */
    MyBean myBean = ctx.getBean(MyBean.class);

    // 拿环境变量
    Environment env = ctx.getEnvironment();
    System.out.println(myBean.sayWord());
    System.out.println(myBean.getMyName());
    System.out.println(env.getProperty("appId"));


  }

}
