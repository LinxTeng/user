package com.hoho.common.facede;

public interface EmailService {
  public void sendMail(String to, String subject, String htmlText);
}
