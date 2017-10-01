package com.hoho.user;



public class Domain {

    public static void main(String[] args) {
        Thread thred = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    synchronized (this) {
                        System.out.println("现在是北京时间：" + System.currentTimeMillis());
                        try {
                            this.wait(1000);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }

            }
        });
        thred.start();
    }
}
