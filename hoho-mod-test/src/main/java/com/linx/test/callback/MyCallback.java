package com.linx.test.callback;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

/**
 * 定义bean初始化个阶段的回调
 * 
 * @author Linx
 *
 */
@Component
public class MyCallback implements InitializingBean, DisposableBean, Lifecycle {

  // InitializingBean接口的实现:baan初始化前的回调
  // 相当于<bean init-method="init"/>
  // 或者使用@PostConstruct
  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("初始化前我做了些事情");

  }

  // DisposableBean接口的实现：bean初始化后的回调
  // 相当于<bean destroy-method="destroy"/>
  // 或者使用@PreDestroy
  @Override
  public void destroy() throws Exception {
    System.out.println("销毁后我做了些事情");

  }


  // 下面都是Lifecycle接口的实现：容器管理bean时各个阶段的回调
  @Override
  public void start() {
    System.out.println("阶段：start");
  }

  @Override
  public void stop() {
    System.out.println("阶段：stop");

  }

  @Override
  public boolean isRunning() {
    System.out.println("阶段：isRunning");
    return false;
  }

}
