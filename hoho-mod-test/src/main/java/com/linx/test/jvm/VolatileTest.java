package com.linx.test.jvm;

/**
 * volatile可见性测试 <br>
 * 有volatile是a后续不会递增 <br>
 * 没有volatile时着继续会递增
 * 
 * @author yunnex
 * @date 2018年1月30日
 */
public class VolatileTest {
    boolean running = true;
    int a = 0;

    public static void main(String[] args) throws InterruptedException {
        final VolatileTest testValitate = new VolatileTest();
        Thread threada = new Thread(new Runnable() {
            @Override
            public void run() {
                while (testValitate.running) {
                    testValitate.a++;
                }
            }
        });
        threada.start();
        threada.sleep(10);
        testValitate.running = false;
        while (true) {
            threada.sleep(1000);
            System.out.println(testValitate.a);
        }
    }
}
