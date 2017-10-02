package com.hoho.user;

import java.io.IOException;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = {"classpath*:/META-INF/spring/applicationContext.xml"})
public class TestBase extends AbstractJUnit4SpringContextTests {

  @Test
  public void run() throws IOException {
    System.in.read();
  }
}
