package com.linx.test.Thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁和非公平锁，体现在多个线程竞争同一个锁时，具体是谁先获得锁。
 * 
 * @author Linx
 *
 */
public class FairLockTest {

	public class Service {
		private ReentrantLock lock;

		public Service(boolean isFair) {
			lock = new ReentrantLock(isFair);
		}

		public void serviceMethod() {
			try {
				lock.lock();
				System.out.println("ThreadName=" + Thread.currentThread().getName() + "获得锁");
			} finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		// 公平锁
		// final Service service=new FairLockTest().new Service(true);
		// 非公平锁
		final Service service = new FairLockTest().new Service(false);
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println("*线程" + Thread.currentThread().getName() + "运行了");
				service.serviceMethod();
			}
		};

		Thread[] threadArray = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threadArray[i] = new Thread(runnable);
		}
		for (int i = 0; i < 10; i++) {
			threadArray[i].start();
		}
	}
}
