package com.hoho.user;

import java.io.IOException;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = {"classpath*:/META-INF/spring/applicationContext.xml"})
@Transactional
public class TestBase extends AbstractTransactionalJUnit4SpringContextTests {

  @Test
  public void run() throws IOException {
    System.in.read();
  }
}
