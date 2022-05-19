package org.xinghe.algorithm.basics;

/**
 * 不用+- ////// *** //// 实现加减乘除
 *
 * @author 星河君❀❀ 2022/5/18 22:08
 * @see [相关类/方法]
 * @since [版本号]
 */
public class CalculatorTest {
    public static int add(int a, int b) {
        int ans = a;
        while (b != 0) {
            // 无进位相加
            ans = a ^ b;
            // 进位信息赋值给b
            b = (a & b) << 1;
            // 无进位的和赋值给a，进行下次循环。当进位信息没有了，这个ans就是和的值。
            a = ans;
        }
        return ans;
    }

    public static int minus(int a, int b) {
        return add(a, add(~b, 1)); // a加上b的相反数，b的相反数就是b取反加一
    }

    /**
     * 乘数
     * a    1010
     * b    1001
     *    ------
     *      1010
     *     0000
     *    0000
     *   1010
     *   -------
     *   以上几个数相加
     *   1011010
     *
     * @param a 一个
     * @param b b
     * @return int
     */
    public static int multi(int a, int b) {
        //
        if (a == 0 || b == 0) {
            return 0;
        }
        int res = a;
        while ((b & 1) == 1) {
            res = add(res, a);
            //
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(add(1, -10));
        System.out.println(minus(1, 10));
    }
}