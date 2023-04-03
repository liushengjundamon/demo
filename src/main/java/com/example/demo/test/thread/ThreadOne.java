package com.example.demo.test.thread;

public class ThreadOne extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName()+"被执行了！");
        }
    }
}
