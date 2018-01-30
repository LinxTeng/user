package com.hoho.test.jvm;

/**
 * volatile可见性测试 <br>
 * 有volatile是a后续不会递增 <br>
 * 没有volatile时着继续会递增
 * 
 * @author yunnex
 * @date 2018年1月30日
 */
public class VolatileTest implements Runnable {
    volatile boolean running = true;
    public int a = 0;

    public static void main(String[] args) throws InterruptedException {
        VolatileTest testValitate = new VolatileTest();
        Thread threadA = new Thread(testValitate);
        threadA.start();
        Thread.currentThread().sleep(10);
        testValitate.setRunning(false);
        while (true) {
            Thread.currentThread().sleep(1000);
            System.out.println(testValitate.getA());
        }
    }

    @Override
    public void run() {
        while (running) {
            a++;
        }
    }
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
