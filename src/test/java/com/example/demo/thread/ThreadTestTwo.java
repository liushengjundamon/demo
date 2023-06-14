package com.example.demo.thread;

public class ThreadTestTwo {
    public static void main(String[] args) {

        ThreadTwo threadTwo = new ThreadTwo();

        Thread t1 = new Thread(threadTwo);
        Thread t2 = new Thread(threadTwo);

        t2.setName("线程二");
        t1.setName("线程一");

        t2.start();
        t1.start();

    }
}
