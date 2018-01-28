package com.hoho.test.jvm;

/**
 * 测试虚拟机栈和本地方法栈溢出</br>
 * VM Args:-Xss128k
 * 
 * @author Linx
 *
 */
public class JavaVMStackSOF {
  private int stackLength = 1;

  public void stackLeak() {
    stackLength++;
    stackLeak();
  }

  public static void main(String[] args) {
    JavaVMStackSOF oom = new JavaVMStackSOF();
    try {
      oom.stackLeak();
    } catch (Throwable e) {
      System.out.println("stack length:" + oom.stackLength);
      throw e;
    }
  }
}
