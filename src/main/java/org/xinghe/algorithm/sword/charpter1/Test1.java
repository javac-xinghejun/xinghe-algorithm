package org.xinghe.algorithm.sword.charpter1;

import java.util.Random;

/**
 * 题目：输入2个int型整数，它们进行除法计算并返回商，要求不得使用乘号'*'、除号'/'及求余符号'%'。
 * 当发生溢出时，返回最大的整数值。假设除数不为0。
 * 例如，输入15和2，输出15/2的结果，即7。
 *
 * @author 星河君❀❀ 2022/5/9 20:10
 * @see [相关类/方法]
 * @since [版本号]
 */
public class Test1 {

    /**
     * 分
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @return int
     */
    public static int divide(int dividend, int divisor) {
        // 思路：看num可以减去divisor多少次。
        boolean resultLgZero = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        if (Integer.MIN_VALUE == dividend && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int divideCount = 0;
        int remainder = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend - divisor > 0) {
            remainder = dividend - divisor;
            dividend = remainder;
            divideCount++;
        }
        return resultLgZero ? divideCount : -divideCount;
    }

    public static int divideTest(int dividend, int divisor) {
        return dividend / divisor;
    }

    public static void main(String[] args) {
        int testTimes = 10000;
        int maxValue = Integer.MAX_VALUE;
        boolean allSuccess = true;
        for (int i = 0; i < testTimes; i++) {
            int dividend = (int) (Math.random() * maxValue);
            int divisor = (int) (Math.random() * maxValue);
            if (divide(dividend, divisor) != divideTest(dividend, divisor)) {
                System.out.println("dividend:" + dividend + " divisor:" + divisor);
                allSuccess = false;
                break;
            }
        }
        System.out.println("allSuccess:" + allSuccess);
    }
}
