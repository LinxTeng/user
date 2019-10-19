package com.linx.test.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReenttrantLock实现等待/通知
 * @author Linx
 *
 */
public class ConditongWaitNotifyOk {

	public class MyService{
		//设置锁
		private Lock lock=new ReentrantLock();
		//设置等待/通知条件。可以设置多个，就可以实现多路通知功能
		private Condition condition=lock.newCondition();
		
		public void await() {
			try {
				lock.lock();
				System.out.println("我开始要等待了");
				condition.await();
				System.out.println("等待完后我被唤醒了");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		}
		
		public void signal() {
			try {
				lock.lock();
				System.out.println("通知可以执行了");
				condition.signal();
			} finally {
				lock.unlock();
			}
		}
		
	}
	
	public class ThreadA extends Thread{
		private MyService service;
		
		public ThreadA(MyService service) {
			this.service=service;
		}

		@Override
		public void run() {
			service.await();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyService service=new ConditongWaitNotifyOk().new MyService();
		ThreadA threadA=new ConditongWaitNotifyOk().new ThreadA(service);
		threadA.start();
		Thread.sleep(1000);
		service.signal();;
	}
}
