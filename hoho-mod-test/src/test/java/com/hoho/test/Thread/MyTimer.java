package com.hoho.test.Thread;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时任务
 * 
 * @author Linx
 *
 */
public class MyTimer {

	public static void main(String[] args) throws InterruptedException {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) - 5);
		Date runDate = calendar.getTime();

		// 任务1
		TimerTask task1 = new TimerTask() {
			@Override
			public void run() {
				try {
					System.out.println("begin time:" + System.currentTimeMillis());
					Thread.sleep(1000);
					System.out.println("end time:" + System.currentTimeMillis());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		// 设置一个定时任务
		Timer timer = new Timer();
		// timer.schedule(task1, runDate, 2000);

		// 追赶性
		timer.scheduleAtFixedRate(task1, runDate, 2000);
	}
}
