package com.hoho.test.xmlconfig;

public abstract class CommandMamager {
  public void process() {
    Command command = createCommand();
    command.execute();
    System.out.println("执行了已知方法，我又执行了其他的动作");
  }

  protected abstract Command createCommand();
}
