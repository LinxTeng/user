package com.hoho.test.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanfactory {

  @Bean
  public MyBean myBean() {
    return new MyBean();
  }
}
