package com.hoho.test.event;

import org.springframework.context.ApplicationEvent;

public class BlackListEvent2 extends ApplicationEvent {

  private static final long serialVersionUID = 1L;
  private final String address;
  private final String test;

  public BlackListEvent2(Object source, String address, String test) {
    super(source);
    this.address = address;
    this.test = test;
  }

  public String getAddress() {
    return address;
  }

  public String getTest() {
    return test;
  }

}
