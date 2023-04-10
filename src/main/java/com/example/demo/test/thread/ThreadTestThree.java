package com.example.demo.test.thread;

public class ThreadTestThree {

    public static void main(String[] args) {

        ThreadTwo threadTwo = new ThreadTwo();
        ThreadOne threadOne = new ThreadOne();

        Thread thread1 = new Thread(threadOne, "线程1");
        Thread thread2 = new Thread(threadTwo, "线程2");
        thread1.setPriority(1);
        thread2.setPriority(10);
        thread1.start();
        thread2.start();


    }

}
