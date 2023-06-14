package com.example.demo.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadFour implements Runnable {

    static int number = 1;
    static Lock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true) {

            lock.lock();

            try {
                if (number <= 5000) {
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }
}

