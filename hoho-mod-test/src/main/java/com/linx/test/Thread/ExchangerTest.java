package com.linx.test.Thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用于线程间的数据交换 <br>
 * 适用场景:校对工作
 * 
 * @author Linx
 *
 */
public class ExchangerTest {
	private static final Exchanger<String> exgr = new Exchanger<>();

	private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

	public static void main(String[] args) {
		// 第一个线程
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					String A = "银行流水A";
					exgr.exchange(A);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		// 第二个线程
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					String B = "银行流水B";
					String A = exgr.exchange(B);
					System.out.println("A和B是否一致:" + A.equals(B));
					System.out.println("A录入的是:" + A);
					System.out.println("B录入的是:" + B);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		threadPool.shutdown();
	}
}
