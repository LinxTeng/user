package com.linx.test.callback;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 实现ApplicationContextAware接口能拿到当前的容器 实现
 * 
 * @author Linx
 *
 */
@Component
public class MyAware implements ApplicationContextAware, BeanNameAware {

  // ApplicationContextAware的实现
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    System.out.println("我被初始化了，当前:Application的名称是：" + applicationContext.getId());
  }

  // BeanNameAware
  @Override
  public void setBeanName(String name) {
    System.out.println("我的beanName是:" + name);
  }

}
