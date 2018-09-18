package com.hoho.test.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.hoho.test.aop")
@EnableAspectJAutoProxy
public class BeanScan {

}
