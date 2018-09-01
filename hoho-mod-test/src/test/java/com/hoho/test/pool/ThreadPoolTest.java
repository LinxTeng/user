package com.hoho.test.pool;

public class ThreadPoolTest {
	public static void main(String[] args) {
		DefaultThreadPool<Job> pool = new DefaultThreadPool<>();
		// 新建一个job
		Job job = new ThreadPoolTest().new Job();
		pool.execute(job);
	}

	class Job extends Thread {
		@Override
		public void run() {
			System.out.println("我是一个job");
		}

	}
}
