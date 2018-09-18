package com.haho.hoho.test;

/**
 *  ÿª§œﬂ≥Ã
 *
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread() {
            int i = 0;

            @Override
            public void run() {
                try {
                    while (true) {
                        i++;
                        System.out.println("I=" + i);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            public int geti() {
                return i;
            }
        };
        a.setDaemon(true);
        a.start();

        System.out.println("main end");
    }
}
