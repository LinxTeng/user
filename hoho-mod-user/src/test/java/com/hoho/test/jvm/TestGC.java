package com.hoho.test.jvm;

public class TestGC {
  private static final int _1MB = 1024 * 1024;

  /**
   * 启用serial/serial old模式。如果不设置本例默认会是Parallel Scavenge+Serial Old模式<br>
   * vM args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
   * -XX:+UseSerialGC
   */
  public static void testAllocation() {
    byte[] allocation1, allocation2, allocation3, allocation4;
    allocation1 = new byte[2 * _1MB / 4];
    allocation2 = new byte[2 * _1MB];
    allocation3 = new byte[2 * _1MB];
    allocation4 = new byte[4 * _1MB];
  }

  /**
   * vM args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
   * -XX:PretenureSizeThreshold=3145728
   */
  public static void testPretenureSizeThreshold() {
    byte[] allocation;
    allocation = new byte[4 * _1MB];
  }

  /**
   * vM args:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
   * -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
   */
  public static void testTenuringThrehold() {
    byte[] allocation1, allocation2, allocation3, allocation4;
    allocation1 = new byte[_1MB / 4];
    // allocation4 = new byte[_1MB / 4];
    allocation2 = new byte[4 * _1MB];
    allocation3 = new byte[4 * _1MB];
    allocation3 = null;
    allocation3 = new byte[4 * _1MB];
  }

  public static void main(String[] args) {
    // TestGC.testAllocation();
    // TestGC.testPretenureSizeThreshold();
    TestGC.testTenuringThrehold();
  }
}
