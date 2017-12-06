package com.hoho.user.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ThreadLocalTest {
    Mystatic mystatic = new Mystatic();

    public void add() {
        mystatic.add();
    }

    public long get() {
        return mystatic.get();
    }

    // ThreadLocal应用于数据库操作
    private static Connection connect = null;
    private static ThreadLocal<Connection> local = new ThreadLocal<>();

    public static Connection openConnection() throws SQLException {
        if (local.get() == null) {
            local.set(DriverManager.getConnection(""));
        }
        return local.get();
    }

    public static void closeConnection() throws SQLException {
        if (local.get() != null) {
            local.get().close();
        }
    }

    // 帮助理解ThreadLocal
    static Mystatic mystatic1;
    static Mystatic mystatic2;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mystatic1 = new Mystatic();
                // 属于线程1
                mystatic1.add();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 属于线程1
                mystatic2 = new Mystatic();
                mystatic2.add();
            }
        }).start();
        // 这里已经数据另一个线程了
        // 所以会报空指针错误。
        System.out.println(mystatic1.get());
        System.out.println(mystatic2.get());
    }

    static class Mystatic {
        // 加static和不加static会员两种不同结果
        static ThreadLocal<Integer> local = new ThreadLocal<>();
        // ThreadLocal<Integer> local = new ThreadLocal<>();
        static int i = 0;

        public int get() {
            return local.get();
            // return i;
        }

        public void add() {
            System.out.println(this);
            i++;
            local.set(i);
        }
    }
}
