package com.example.demo.util;

import java.util.Random;

/**
 * ID生成工具
 */
public class IDGenerator {

    private static final char[] ORIGINAL =
            "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /**
     * 生成ID
     *
     * @param length
     * @return
     */
    public static String generate(int length) {
        Random random = new Random();
        String code = "";
        for (int i = 0; i < length; i++) {
            int temp = random.nextInt(62);
            code += ORIGINAL[temp];
        }
        return code;
    }

    /**
     * 返回一个16位的随机字符串
     *
     * @return
     */
    public static String getPid() {
        return generate(16);
    }
}
