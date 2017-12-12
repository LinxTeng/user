package com.hoho.user.BaseJavaConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.hoho.user.service.impl", excludeFilters = @Filter(MyService.class))
public class BeanScan {

}
