package com.hoho.test.xmlconfig;

public class Command {
  private Object State;

  public Object getState() {
    return State;
  }

  public void setState(Object state) {
    State = state;
  }

  public void execute() {
    System.out.println("我执行了execute");
  }

}
