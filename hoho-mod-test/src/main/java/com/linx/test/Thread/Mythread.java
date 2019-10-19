package com.linx.test.Thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Mythread extends Thread {
  private AtomicInteger count = new AtomicInteger(5);

  public Mythread() {
    super();
    // TODO Auto-generated constructor stub
  }

  public Mythread(String name) {
    super(name);
    // TODO Auto-generated constructor stub
  }

  public Mythread(Runnable target) {
    super(target);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void run() {
    super.run();
    // for (int i = 0; i < 10; i++) {

    System.out
        .println("由" + this.currentThread().getName() + "计算,count=" + count.decrementAndGet());
    // }
  }

  public static void main(String[] args) {
    // 变量不共享
    // Mythread mythreadA = new Mythread("A");
    // Mythread mythreadB = new Mythread("B");
    // mythreadA.start();
    // mythreadB.start();
    Mythread mythread = new Mythread();

    // 变量共享
    Thread threadA = new Thread(mythread, "A");
    Thread threadB = new Thread(mythread, "B");
    Thread threadC = new Thread(mythread, "C");
    threadA.start();
    threadB.start();
    threadC.start();

  }
}
