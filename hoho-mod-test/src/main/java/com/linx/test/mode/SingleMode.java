package com.linx.test.mode;

import java.io.Serializable;

/**
 * 单例模式
 * 
 * @author Linx
 *
 */
public class SingleMode {

	// --------------------------------- 延迟加载模式，也叫懒汉模式
	public static class MyObject {
		public static Object obj;

		public static Object getInstance() {
			if (obj != null) {
				return obj;
			}
			synchronized (MyObject.class) {
				if (obj != null) {
					return obj;
				}
				obj = new MyObject();
			}
			return obj;
		}
	}

	public static class MyThread extends Thread {
		@Override
		public void run() {
			super.run();
			// 懒汉模式
			// System.out.println(MyObject.getInstance().hashCode());
			// 内部类模式
			// System.out.println(MyStaticObjct.getInstance().hashCode());
			// 使用枚举
			System.out.println(MyEnumObject.connectionFactory.getInstance().hashCode());
		}

	}

	public static void main(String[] args) {
		MyThread[] thradPool = new MyThread[10];
		for (int i = 0; i < 10; i++) {
			thradPool[i] = new MyThread();
		}
		for (MyThread myThread : thradPool) {
			myThread.start();
		}
	}

	// --------------------------------- 使用内部静态内实现单例
	public static class MyStaticObjct implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public static class myObject {
			public static Object obj = new Object();
		}

		public static Object getInstance() {
			return MyStaticObjct.myObject.obj;
		}

		// 在序列化与反序列化时需要此方法。
		protected Object readResolve() {
			return myObject.obj;
		}

	}

	// ------------------------------- 枚举特性的单例
	public enum MyEnumObject {
		connectionFactory;
		private Object obj;

		private MyEnumObject() {
			obj = new Object();
		}

		public Object getInstance() {
			return obj;
		}

	}
}
