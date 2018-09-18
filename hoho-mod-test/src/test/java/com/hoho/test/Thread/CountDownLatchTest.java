package com.hoho.test.Thread;

import java.util.concurrent.CountDownLatch;

/**
 * 当调用awain方法时，当且仅当CountDownLatch对象的内部计数器的值为0时，才不会阻塞当前线程。
 * 
 * @author Linx
 *
 */
public class CountDownLatchTest {
	static CountDownLatch c = new CountDownLatch(2);

	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(1);
				c.countDown();
				System.out.println(2);
				c.countDown();

			}
		}).start();

		// 这里进行等待
		c.await();
		System.out.println("3");
	}
}
