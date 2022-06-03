package org.xinghe.algorithm.review;

import cn.hutool.core.util.RandomUtil;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/9 20:10
 * @see [相关类/方法]
 * @since [版本号]
 */
public class BinaryCalculatorTest {
    /**
     * 相加
     *
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        // 结果，每一轮计算都会是a和b无进位相加的结果，加上进位信息
        int res = a;
        // 记录进位信息，依次从最低位到最高位的进位信息
        // 进位信息：a & b == 1时有进位;
        while (b != 0) {
            // 无进位相加
            res = a ^ b;
            // 进位信息
            b = a & b;
            // 下一轮计算：进位要放到左边一位上去
            b = b << 1;
            // 下一轮计算：当前结果赋值给a
            a = res;
        }
        return res;
    }

    public static int minus(int a, int b) {
        return add(a, add(~b, 1));
    }

    public static int multiply(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        int res = a;
        for (int i = b; i > 1; i--) {
            res = add(res, a);
        }
        return res;
    }

    /**
     * 1. a左移的次数，左移N次，则说明a至少有2^N 个b；
     * 2. a左移结果减去b的余数M，那么总的余数是(2^N)*m;
     * 3. 用a - (2^(N-1) + 1)*b，就可以得出总余数，计算这个总余数包含几个b，加上即可得到最终结果。
     *
     * @param a 一个
     * @param b b
     * @return int
     */
    public static int divide(int a, int b) {
       return 0;
    }

    public static void main(String[] args) {

        System.out.println(86229 / 987);
        System.out.println(divide(8, 3));
        System.out.println(divide(86229, 987));
        System.out.println(divide(7, 0));
        System.out.println(divide(-99, 199));
        System.out.println(-99 / 199);
        for (int i = 0; i < 10000; i++) {
            int a = RandomUtil.randomInt(100000);
            int b = RandomUtil.randomInt(100000);
            int res = divide(a, b);
            int res1 = a / b;
            if (res != res1) {
                System.out.println("a:" + a + " b:" + b);
                break;
            }
        }
        System.out.println("======");
    }
}
