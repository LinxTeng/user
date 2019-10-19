package com.linx.test.Thread;

public class RunThread extends Thread {
    private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }



    @Override
    public void run() {
        System.out.println("进入run了");
        while (isRunning == true) {
            synchronized (this) {

            }
        }
        System.out.println("线程被停止");
    }

    public static void main(String[] args) {
        try {
            RunThread runthread = new RunThread();
            runthread.start();
            Thread.sleep(1000);
            runthread.setRunning(false);
            System.out.println("已经赋值为false");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
