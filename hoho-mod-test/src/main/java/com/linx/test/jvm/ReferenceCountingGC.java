package com.linx.test.jvm;

/**
 * 垃圾回收<br>
 * args -XX:+PrintGCDetails
 * 
 * @author Linx
 *
 */
public class ReferenceCountingGC {
  public Object instance = null;
  private static final int _1MB = 1024 * 1024;
  private byte[] bigSize = new byte[2 * _1MB];

  public static void testGC() {
    ReferenceCountingGC objA = new ReferenceCountingGC();
    ReferenceCountingGC objB = new ReferenceCountingGC();

    objA.instance = objB;
    objB.instance = objA;

    objA = null;
    objB = null;

    System.gc();
  }

  public static void main(String[] args) {
    ReferenceCountingGC.testGC();
  }
}
