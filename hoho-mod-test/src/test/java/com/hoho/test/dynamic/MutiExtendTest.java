package com.hoho.test.dynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MutiExtendTest {
    public static class GrandFather {
        void thinking() {
            System.out.println("i am grandfather");
        }
    }

    public static class Father extends GrandFather {
        void thinking() {
            System.out.println("i am father");
        }

    }

    public static class Son extends Father {
        void thinking() {
            // System.out.println("i am son");
            // 输出grandfather
            try {
                MethodType mt = MethodType.methodType(void.class);
                MethodHandle mh = MethodHandles.lookup().findSpecial(GrandFather.class, "thinking", mt, getClass());
                mh.invoke(this);
            } catch (Throwable e) {
                // TODO: handle exception
            }
        }
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.thinking();
    }
}
