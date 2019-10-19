package com.linx.test.dynamic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MutiExtendTest {
    class GrandFather {
        void thinking() {
            System.out.println("i am grandfather");
        }
    }

    class Father extends GrandFather {
        void thinking() {
            System.out.println("i am father");
        }
    }

    class Son extends Father {
        void thinking() {
            // System.out.println("i am son");
            // 输出grandfather
            try {
                MethodType mt = MethodType.methodType(void.class);
                // 还是会打印father
                // MethodHandle mh = lookup().findSpecial(GrandFather.class, "thinking", mt,
                // getClass());
                // mh.invoke(this);
                // 下面打印grandfather
                MethodHandle mh = MethodHandles.lookup().findVirtual(GrandFather.class, "thinking", mt).bindTo(new GrandFather());
                mh.invokeExact();
            } catch (Throwable e) {
                // TODO: handle exception
            }
        }
    }

    public static void main(String[] args) {
        (new MutiExtendTest().new Son()).thinking();
    }
}
