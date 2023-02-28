package com.example.demo.test.designmode;

/**
 * 单例模式
 */
public class SingletonPattern {

    private SingletonPattern() {
    }

    /**
     * 单例饿汉
     */
    private static SingletonPattern sortAlgorithm1 = new SingletonPattern();

    public static SingletonPattern getInstance1() {
        return sortAlgorithm1;
    }

    /**
     * 单例懒汉
     */
    private static SingletonPattern sortAlgorithm2;

    public static SingletonPattern getInstance2() {
        sortAlgorithm2 = new SingletonPattern();
        return sortAlgorithm2;
    }
}
