package com.hoho.user.BaseJavaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanfactory {

  @Bean
  public MyBean myBean() {
    return new MyBean();
  }
}
