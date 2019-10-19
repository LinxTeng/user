package com.linx.test.javaconfig;

import org.springframework.beans.factory.annotation.Value;

public class MyBean {

  @Value("你好")
  private String myName;

  public String sayWord() {
    return "这是myBean";
  }

  public String getMyName() {
    return myName;
  }

  public void setMyName(String myName) {
    this.myName = myName;
  }


}
