package com.linx.test.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements ApplicationEventPublisherAware {
  private ApplicationEventPublisher publisher;


  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.publisher = applicationEventPublisher;

  }

  public void sendEmail(String adrress, String text) {
    System.out.println("我往地址:" + adrress + ",发送的内容:" + text);
    BlackListEvent event = new BlackListEvent(this, adrress, text);
    publisher.publishEvent(event);

  }

}
