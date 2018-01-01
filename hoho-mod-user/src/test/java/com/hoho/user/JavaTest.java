package com.hoho.user;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = {"classpath*:/spring/testApplicationContext.xml"})
public class JavaTest extends AbstractJUnit4SpringContextTests {

}
