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
        // 需要优化，如果是Integer.MAX_VALUE - 1，那需要执行的时间太长了
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

    public static int divideSword(int dividend, int divisor) {
        if (Integer.MIN_VALUE == dividend && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int negative = 2;
        if (dividend > 0) {
            dividend = -dividend;
            negative--;
        }
        if (divisor > 0) {
            divisor = -divisor;
            negative--;
        }
        int result = divideCore(dividend, divisor);
        return negative == 1 ? -result : result;
    }

    private static int divideCore(int dividend, int divisor) {
        int result = 0;
        while (dividend <= divisor) {
            int value = divisor;
            int quotient = 1;
            while (value >= 0xc0000000 && dividend <= value + value) {
                quotient += quotient;
                value += value;
            }
            result += quotient;
            dividend -= value;
        }

        return result;
    }

    public static void main(String[] args) {
        int testTimes = 10000;
        int maxValue = Integer.MAX_VALUE;
        boolean allSuccess = true;
        for (int i = 0; i < testTimes; i++) {
            int dividend = -(int) (Math.random() * maxValue);
            int divisor = (int) (Math.random() * maxValue);
            if (divide(dividend, divisor) != divideSword(dividend, divisor)) {
                System.out.println("dividend:" + dividend + " divisor:" + divisor);
                allSuccess = false;
                break;
            }
        }
        System.out.println("allSuccess:" + allSuccess);

        long l = System.currentTimeMillis();
        int divide = divide(Integer.MAX_VALUE, 1);
        System.out.println(System.currentTimeMillis() - l); // 花了3秒
    }
}
