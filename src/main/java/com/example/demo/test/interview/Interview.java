package com.example.demo.test.interview;

import java.util.UUID;

/**
 * 面试题训练
 */
public class Interview {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
        int b = 1;
        String a = "1";
        StringBuffer c = new StringBuffer("1");
        String test = test(a);
        System.out.println(test);

        System.out.println(Math.round(-11.6));
        System.out.println(Math.ceil(-7.1));
        System.out.println(Math.floor(-7.9));
        //2X2的二次方
        System.out.println(2 << 3);
        int[] arr = new int[10];
        System.out.println(arr.length + "**********" + a.length());
    }

    public static String test(String a) {
        return "您好!";
    }

    public static String test(String a, int b) {
        return "您好啊.";
    }

    public static String test(String a, int b, StringBuffer c) {
        return "您好不?";
    }
}
