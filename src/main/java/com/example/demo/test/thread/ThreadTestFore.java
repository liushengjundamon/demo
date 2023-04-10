package com.example.demo.test.thread;

public class ThreadTestFore {
    public static void main(String[] args) {

        ThreadFour threadFour1 = new ThreadFour();
        ThreadFour threadFour2 = new ThreadFour();
        ThreadFour threadFour3 = new ThreadFour();

        Thread thread1 = new Thread(threadFour1, "线程1");
        Thread thread2 = new Thread(threadFour2, "线程2");
        Thread thread3 = new Thread(threadFour3, "线程3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
