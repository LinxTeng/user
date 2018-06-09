package com.hoho.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.junit.Test;
import org.springframework.stereotype.Service;

public class LearnTest {
    static int count = 0;

    public void testThread() {
        // 不用线程池时会拖累系统
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    count++;
                }
            }).start();
        }
        System.out.println("你好");
        System.out.println(count);
    }

    @Test
    public void testFureTask() {
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(10000);
                return "Thread-name:" + Thread.currentThread().getName();
            }
        });

        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testExeCutor() {
        int cpuCoreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(cpuCoreCount);
        Map<String, Object> map = new ConcurrentHashMap<>();
        fixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("我执行了");
            }
        });
        Thread.currentThread().getName();
    }

    @Test
    public void testReflect() throws Exception {
        Class<?> myReflectClass = MyReflect.class;

        // Method[] methods = myReflectClass.getMethods();
        // for (Method method : methods) {
        // System.out.println(method.getName());
        // }
        Object object = myReflectClass.newInstance();
        Field[] fields = myReflectClass.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            System.out.println(fieldName);
            Method method = myReflectClass.getMethod("getName");
            Object aa = method.invoke(object);
            System.out.println(aa);
        }

    }

    @Service
    public static class MyReflect {
        private String name;
        private String value;

        public MyReflect() {
            System.out.println("我被创建了");
        }

        public MyReflect(String name) {
            System.out.println("我创建了name");
        }

        public String getName() {
            System.out.println("调用了getName");
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            System.out.println("调用了getValue");
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}

