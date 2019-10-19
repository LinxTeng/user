package com.linx.test.Thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
 * 读写锁
 */
public class ReadWriteLock {

	public class Service {
		private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

		public void read() {
			try {
				lock.readLock().lock();
				System.out.println("获取读锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.readLock().unlock();
			}
		}

		public void write() {
			try {
				lock.writeLock().lock();
				System.out.println("获取写锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.writeLock().unlock();
			}
		}
	}

	public class ThreadA extends Thread {
		Service service;

		ThreadA(Service service) {
			this.service = service;
		}

		@Override
		public void run() {
			super.run();
			service.read();
		}
	}

	public class ThreadB extends Thread {
		Service service;

		ThreadB(Service service) {
			this.service = service;
		}

		@Override
		public void run() {
			super.run();
			service.write();
		}
	}

	public static void main(String[] args) {
		Service service = new ReadWriteLock().new Service();
		ThreadA threadA = new ReadWriteLock().new ThreadA(service);
		threadA.setName("A");
		ThreadB threadB = new ReadWriteLock().new ThreadB(service);
		threadB.setName("B");
		threadA.start();
		threadB.start();
	}
}
