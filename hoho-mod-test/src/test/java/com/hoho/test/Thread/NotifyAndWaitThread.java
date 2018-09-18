package com.hoho.test.Thread;

import java.util.ArrayList;
import java.util.List;

public class NotifyAndWaitThread {
	/**
	 * 多个线性被notify之后,仍热需要去竞争锁。
	 * @param args
	 */

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        ThreadA threada = new NotifyAndWaitThread().new ThreadA(list);
//        ThreadB threadb = new NotifyAndWaitThread().new ThreadB(list);
//        threada.start();
//        threadb.start();
    	
    	Object lock=new Object();
    	ThreadC threadC= new NotifyAndWaitThread().new ThreadC(lock);
    	threadC.setName("treadC");
    	ThreadC2 threadC2= new NotifyAndWaitThread().new ThreadC2(lock);
    	threadC2.setName("threadC2");
    	ThreadC3 threadC3= new NotifyAndWaitThread().new ThreadC3(lock);
    	threadC3.setName("threadC3");
    	
    	threadC.start();
    	threadC2.start();
    	threadC3.start();

    }

    public class ThreadA extends Thread {
        public List<String> list;

        ThreadA(List<String> list) {
            this.list = list;
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 10; i++) {
                list.add("hello word");
                System.out.println("新增了一个值");
            }
        }
    }

    public class ThreadB extends Thread {
        public List<String> list;

        ThreadB(List<String> list) {
            this.list = list;
        }

        @Override
        public void run() {
            super.run();
            while (true) {
                if (list.size() == 5) {
                    System.out.println("我退出了");
                }
            }
        }
    }
    
    
    public class ThreadC extends Thread{
    	Object lock;
    	ThreadC(Object lock){
    		this.lock=lock;
    	}
		@Override
		public void run() {
			super.run();	
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName()+" beging");
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				System.out.println(Thread.currentThread().getName()+" end");
				try {
					this.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    }
    
    public class ThreadC2 extends Thread{
    	Object lock;
    	ThreadC2(Object lock){
    		this.lock=lock;
    	}
		@Override
		public void run() {
			super.run();	
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName()+" beging");
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" end");
			}
		}
    }
    
    public class ThreadC3 extends Thread{
    	Object lock;
    	ThreadC3(Object lock){
    		this.lock=lock;
    	}
		@Override
		public void run() {
			super.run();	
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName()+" beging");
				lock.notifyAll();
				System.out.println(Thread.currentThread().getName()+" end");
			}
		}
    }
}
