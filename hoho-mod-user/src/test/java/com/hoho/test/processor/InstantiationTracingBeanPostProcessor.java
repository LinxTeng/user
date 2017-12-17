package com.hoho.test.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 可以理解为全局的bean拦截器
 * 
 * @author Linx
 *
 */
@Component
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    System.out.println("开始前我做了些事情,当前beanName为" + beanName);
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    System.out.println("初始后我做了些事情,当前beanName为" + beanName);
    return bean;
  }

}
