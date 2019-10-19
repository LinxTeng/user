package com.linx.test.pool;

import java.sql.Connection;
import java.util.LinkedList;

public class ConnectionPool {
	private LinkedList<Connection> pool = new LinkedList<>();

	public ConnectionPool(int initialSize) {
		if (initialSize > 0) {
			for (int i = 0; i < initialSize; i++) {
				pool.addLast(ConnectionDriver.createConnection());
			}
		}
	}

	/**
	 * 释放连接
	 */
	public void releasePool(Connection connection) {
		if (connection != null) {
			synchronized (pool) {
				pool.addLast(connection);
				pool.notify();
			}
		}
	}

	/**
	 * 获取连接
	 * 
	 * @param mills
	 * @return
	 * @throws InterruptedException
	 */
	public Connection getCollection(long mills) throws InterruptedException {
		synchronized (pool) {
			if (mills < 0) {
				while (pool.isEmpty()) {
					pool.wait();
				}
				return pool.removeFirst();
			}
			long futureTime = System.currentTimeMillis() + mills;
			long remainTime = mills;
			while (pool.isEmpty() && remainTime >= 0) {
				pool.wait(remainTime);
				remainTime = futureTime - System.currentTimeMillis();
			}
			Connection result = null;
			if (!pool.isEmpty()) {
				result = pool.removeFirst();
			}
			return result;
		}

	}
}
