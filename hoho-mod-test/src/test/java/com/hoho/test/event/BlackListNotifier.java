package com.hoho.test.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class BlackListNotifier implements ApplicationListener<BlackListEvent> {

  @Override
  public void onApplicationEvent(BlackListEvent event) {
    System.out.println("我监听到了地址为:" + event.getAddress() + "内容为:" + event.getTest());

  }

}
