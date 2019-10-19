package com.linx.test.Thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 让一组线程到达一个屏障时被阻塞，直到最后一个线程到达屏障时，所有被屏障拦截的线程才会继续执行。<br>
 * 此类可适用于同一时间进行并发操作。
 * 
 * @author Linx
 *
 */
public class CyclicBarrierTest {
	static CyclicBarrier c = new CyclicBarrier(2);

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					c.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				;
				System.out.println(1);
			}
		}).start();

		c.await();
		System.out.println(2);
	}
}
