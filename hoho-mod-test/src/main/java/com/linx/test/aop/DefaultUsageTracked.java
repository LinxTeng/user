package com.linx.test.aop;

public class DefaultUsageTracked implements UsageTracked {

  @Override
  public void incrementUseCount() {
    System.out.println("引入的实现");
  }

}
