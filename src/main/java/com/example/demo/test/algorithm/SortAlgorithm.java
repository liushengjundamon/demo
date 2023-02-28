package com.example.demo.test.algorithm;

import java.util.Arrays;

/**
 * 排序算法
 */
public class SortAlgorithm {

    public static void main(String[] args) {
        int[] arr = {1, 9, 5, 4, 7, 8, 41, 48, 7, 645661};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     *
     * @param number
     * @return
     */
    public static int[] bubbleSort(int[] number) {

        int num;

        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < number.length - 1; j++) {
                if (number[j + 1] < number[j]) {
                    num = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = num;
                }
            }
        }
        return number;
    }
}
