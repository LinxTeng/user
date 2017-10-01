package com.hoho.user;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.hoho.user.service.UserAccountService;

@ContextConfiguration(locations = {"classpath*:/META-INF/spring/applicationContext.xml"})
public class TestBase extends AbstractJUnit4SpringContextTests {
    @Autowired
    UserAccountService userAccountService;

    @Test
    public void aa() {
        userAccountService.sayHollen();
    }
}
