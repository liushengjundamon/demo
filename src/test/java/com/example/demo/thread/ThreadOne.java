package com.example.demo.thread;

public class ThreadOne extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + "**********被执行了！");
        }
    }
}
