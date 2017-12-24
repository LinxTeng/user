package com.hoho.test.event;


import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailService2 {

  /** 本身也是一个监听器，但是如果返回值不为空则发送一个新的事件 */
  @EventListener
  public BlackListEvent2 handleBlackListEvent(BlackListEvent event) {
    System.out.println("EmailService2接收到一个事件,发送一个新的BlackListEvent2");
    BlackListEvent2 blackListEvent2 =
        new BlackListEvent2(this, event.getAddress(), event.getTest());
    return blackListEvent2;
  }
}
