package com.linx.test.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试java堆溢出</br>
 * VM Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError</br>
 * 产生异常：Java heap space
 * 
 * @author Linx
 *
 */
public class HeapOOM {
  static class OOMObject {
  }

  public static void main(String[] args) {
    List<OOMObject> list = new ArrayList<OOMObject>();
    while (true) {
      list.add(new OOMObject());
    }
  }

}
