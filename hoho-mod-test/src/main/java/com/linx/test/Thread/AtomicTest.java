package com.linx.test.Thread;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public class AtomicTest {
	static int[] value = new int[] { 1, 2, 3 };

	static AtomicIntegerArray ai = new AtomicIntegerArray(value);

	static AtomicReference<User> atoRef = new AtomicReference<AtomicTest.User>();

	// 1、必须使用静态方法newUpdate()创建一个更新器。
	private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "old");

	public static void main(String[] args) {
		// 原子更新数组
		System.out.println(ai.getAndSet(0, 5));
		System.out.println(ai.get(0));
		System.out.println(value[0]);
		System.out.println("----原子更新引用-----");
		// 原子更新引用类型
		User user = new User("conan", 20);
		atoRef.set(user);
		User updateUser = new User("Shinichi", 17);
		atoRef.compareAndSet(user, updateUser);
		System.out.println(atoRef.get().getName());
		System.out.println(atoRef.get().getOld());
		System.out.println("----原子更新字段-----");
		User conan = new User("conan", 10);
		System.out.println(a.getAndIncrement(conan));
		System.out.println(a.get(conan));

		Supplier a = ArrayList::new;
		a.get();

	}

	static class User {
		private String name;
		// 2、更新的字段（属性）必须使用public volatile修饰符。
		public volatile int old;

		public User(String name, int old) {
			this.name = name;
			this.old = old;
		}

		public String getName() {
			return name;
		}

		public int getOld() {
			return old;
		}
	}

}
