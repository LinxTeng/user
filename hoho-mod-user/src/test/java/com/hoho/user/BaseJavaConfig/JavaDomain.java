package com.hoho.user.BaseJavaConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hoho.user.service.UserAccountService;

public class JavaDomain {
    public static void main(final String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanScan.class);
        UserAccountService userAccountService = ctx.getBean(UserAccountService.class);
        System.out.println(userAccountService.sayHollen());
    }
}
