package com.example.demo.test.algorithm;

/**
 * 算法题
 */
public class AlgorithmQuestion {

    public static void main(String[] args) {

        /**
         * 黄金分割数（兔子算法）
         */
        int f1 = 1;
        int f2 = 1;
        int f;
        int may = 30;
        /*意思就是，从第三月开始，第三个月等与上个月和上上个月的和，首先把上个月的数取出来赋值给上上个月，
        当前的总数当成上个月的数*/
        for (int i = 3; i <= may; i++) {
            //取出上个月的数
            f = f2;
            //得到当前月的总数，上个月+上上个月，此f2是当前月的数
            f2 = f2 + f1;
            //做完计算上个月的数变成上上个月的数
            f1 = f;
            System.out.println(f2);
        }//每次循环结束，f2变成上个月的数

        /**
         * 自由落体
         */
        double h = 100;
        double s = 100;
        for (int i = 1; i <= 10; i++) {
            h = h / 2;
            s = s + h * 2;
        }
        System.out.println(h + "---" + s);
    }

}
