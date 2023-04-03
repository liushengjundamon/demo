package com.example.demo.test.thread;

/**
 * 线程练习
 */
public class ThreadTestOne {
    public static void main(String[] args) {

        ThreadOne threadOne1 = new ThreadOne();
        ThreadOne threadOne2 = new ThreadOne();

        threadOne1.setName("线程一");
        threadOne2.setName("线程二");

        threadOne1.start();
        threadOne2.start();

}
}
