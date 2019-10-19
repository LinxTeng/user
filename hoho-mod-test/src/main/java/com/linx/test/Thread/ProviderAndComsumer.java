package com.linx.test.Thread;

import java.util.ArrayList;
import java.util.List;

//生产者和消费者模式
public class ProviderAndComsumer {
	// 操作栈
	public class MyStack {
		List<String> list = new ArrayList<>();

		synchronized public void push(String aa) {
			try {
				while  (list.size() > 1) {
					this.wait();
				}
				list.add(aa);
				System.out.println("生产:" + aa);
				this.notify();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		synchronized public void pop() {
			try {
				while (list.size() == 0) {
					this.wait();
				}
				System.out.println("消费：" + list.get(0));
				list.remove(0);
				this.notify();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 生产者

	public class Productor extends Thread {
		MyStack stack = new ProviderAndComsumer().new MyStack();

		Productor(MyStack stack) {
			this.stack = stack;
		}

		@Override
		public void run() {
			int i = 0;
			while (true) {
				stack.push(String.valueOf(i++));
				try {
					this.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	// 消费者
	public class Comsumer extends Thread {
		MyStack stack = new ProviderAndComsumer().new MyStack();

		Comsumer(MyStack stack) {
			this.stack = stack;
		}

		@Override
		public void run() {
			while (true) {
				stack.pop();
				try {
					this.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

	public static void main(String[] args) {
		MyStack stack = new ProviderAndComsumer().new MyStack();
		Productor productor = new ProviderAndComsumer().new Productor(stack);
		Comsumer comsumer = new ProviderAndComsumer().new Comsumer(stack);
		Comsumer comsumer2 = new ProviderAndComsumer().new Comsumer(stack);
		Comsumer comsumer3 = new ProviderAndComsumer().new Comsumer(stack);
		productor.start();
		comsumer.start();
		comsumer2.start();
		comsumer3.start();
	}

}
