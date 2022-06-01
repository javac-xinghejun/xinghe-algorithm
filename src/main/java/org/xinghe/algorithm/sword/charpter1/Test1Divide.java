package org.xinghe.algorithm.sword.charpter1;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/9 20:10
 * @see [相关类/方法]
 * @since [版本号]
 */
public class Test1Divide {
    /**
     * 加法
     *
     * @param a 一个
     * @param b b
     * @return int
     */
    public static int add(int a, int b) {
        int res = a;
        while (b != 0) {
            // 无进位相加
            res = a ^ b;
            b = (a & b) << 1;
            a = res;
        }
        return res;
    }

    public static int minus(int a, int b) {
        return add(a, add(~b, 1));
    }

    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = res + a;
            }
            b = b >>> 1;
            a = a << 1;
        }
        return res;
    }

    public static int divide(int a, int b) {

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(add(1, 8));
        System.out.println(add(1, -8));
        System.out.println(multi(1, -8));
        System.out.println(multi(1, 8));
    }
}
