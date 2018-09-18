package com.hoho.test.Thread;

import org.springframework.validation.annotation.Validated;

/**
 * 工作内存和主内存的一个测试用例
 * @author Linx
 *
 */
public class WorkMemoryTest {

	public class RunThread extends Thread{
		private  boolean isRunning=true;//加上volatile就可以停止了
		public boolean isRunning() {
			return isRunning;
		}
		public void setRunning(boolean isRunning) {
			this.isRunning=isRunning;
		}
		@Override
		public void run() {
			System.out.println("进入了run");
			while(isRunning==true) {
				
			}
			System.out.println("线程被停止了");
		}
	}
	
	public static void main(String[] args) {
		try {
			RunThread runThread=new WorkMemoryTest().new RunThread();
			runThread.start();
			Thread.sleep(1000);
			runThread.setRunning(false);//预想会让线程停止，实际因为工作内存和主内存的导致isRunning未同步。
			System.out.println("已经赋值为false");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
