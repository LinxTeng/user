package com.hoho.core;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Portal {
    private static final Logger logger = Logger.getLogger(Portal.class);

    public static void main(String[] args) {
        try {
            new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/applicationContext.xml");
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("系统异常退出", e);
        }
    }
}
