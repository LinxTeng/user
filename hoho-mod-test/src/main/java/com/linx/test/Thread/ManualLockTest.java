package com.linx.test.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.linx.test.Thread.ThreadLocalTest.Mystatic;

public class ManualLockTest {
    public int inc = 0;
    Lock lock = new ReentrantLock();

    public void increase() {
        lock.lock();
        try {
            inc++;
        } finally {
            lock.unlock();
        }
    }

    public int get() {
        return inc;
    }

    public void testaa(String[] args) {
        final ManualLockTest test = new ManualLockTest();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        test.increase();
                    }
                }
            }).start();;
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(test.get());
    }

    public static void main(String[] args) {
        Mystatic mystatic1 = new Mystatic();
        Mystatic mystatic2 = new Mystatic();
        mystatic1.add();
        mystatic2.add();
        System.out.println(mystatic1.get());
        System.out.println(mystatic2.get());
    }
}
