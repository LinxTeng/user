package com.hoho.common.facede.impl;

import javax.mail.Message;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.hoho.common.TestBase;
import com.hoho.common.facede.EmailService;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;

public class EmailServiceImplTest extends TestBase {
  @Autowired
  EmailService emailService;

  @Test
  public void testSendMail() {
    GreenMail greeMail = new GreenMail(ServerSetup.SMTP);
    // 搭建测试邮件服务器
    greeMail.setUser("test@hoho.com", "123456");
    greeMail.start();
    try {
      // 测试发生邮件
      String subject = "测试邮件";
      String htmlText = "<h3>Test</h3>";
      emailService.sendMail("test2@hoho.com", subject, htmlText);

      // 接受邮件
      greeMail.waitForIncomingEmail(2000, 1);
      Message[] msgs = greeMail.getReceivedMessages();
      System.out.println("接收到主题：" + msgs[0].getSubject());
      System.out.println("接收到内容：" + GreenMailUtil.getBody(msgs[0]).trim());

      Assert.assertEquals(1, msgs.length);
      Assert.assertEquals(subject, msgs[0].getSubject());
      Assert.assertEquals(htmlText, GreenMailUtil.getBody(msgs[0]).trim());
    } catch (Exception e) {
      e.printStackTrace();
    }
    greeMail.stop();
  }
}
