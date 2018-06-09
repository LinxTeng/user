package com.hoho.common.facede.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.hoho.common.facede.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
  @Autowired
  private JavaMailSender javaMailSender;

  private static String systemEmail = "test@hoho.com";

  @Override
  public void sendMail(String to, String subject, String htmlText) {
    // 设置邮件内容
    try {
      MimeMessage msg = javaMailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(msg);
      helper.setFrom(systemEmail);
      helper.setTo(to);
      helper.setSubject(subject);
      helper.setText(htmlText);
      javaMailSender.send(msg);
      System.out.println("邮件发生成功");
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }

}
