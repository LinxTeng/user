package com.hoho.test.jvm;

/**
 * VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M<br/>
 * 本例在jdk7以后已经不起作用。且已经移除PermSize参数的支持
 * 
 * @author Linx
 *
 */
public class RuntimeConstantPoolOOM {
  public static void main(String[] args) {
    // List<String> list = new ArrayList<>();
    // int i = 0;
    // while (true) {
    // list.add(String.valueOf(i++).intern());
    // }
    RuntimeConstantPoolOOM runtimeConstantPoolOOM = new RuntimeConstantPoolOOM();
    runtimeConstantPoolOOM.testintern();
  }

  /**
   * 对于String.intern()的有趣测试
   */
  public void testintern() {
    String str1 = new StringBuilder("计算机").append("软件").toString();
    System.out.println(str1.intern() == str1);

    String str2 = new StringBuilder("ja").append("va").toString();
    System.out.println(str2.intern() == str2);
    System.out.println(str2.intern());
  }
}
