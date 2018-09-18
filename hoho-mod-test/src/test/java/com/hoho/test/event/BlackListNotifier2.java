package com.hoho.test.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BlackListNotifier2 {

  @EventListener
  public void processBlackListEvent(BlackListEvent2 event) {
    System.out
        .println("BlackListNotifier2监听到了地址为:" + event.getAddress() + "内容为:" + event.getTest());
  }
}
