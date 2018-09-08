package com.hoho.test.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 用来控制同时访问特定资源的线程数量。<br>
 * 适用场景：进行流量控制。
 * 
 * @author Linx
 *
 */
public class SemaphoreTest {
	private static ExecutorService threadPool = Executors.newFixedThreadPool(30);

	private static Semaphore s = new Semaphore(10);

	public static void main(String[] args) {
		// 设置30个线程
		for (int i = 0; i < 30; i++) {
			final int j = i;
			threadPool.execute(new Runnable() {

				@Override
				public void run() {
					try {
						s.acquire();// 如果Semaphore对象中没有可用的令牌，这里就会被阻塞。
						System.out.println("save data :" + j);
						s.release();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}

		threadPool.shutdown();
	}
}
