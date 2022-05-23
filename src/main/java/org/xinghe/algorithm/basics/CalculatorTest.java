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
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) { // 1001 & 1 != 0 ===> 1001 & 0001 != 0 说明b最后一位不是0
                res = add(res, a); // 相加1010 + 0 ====> 1010 + 0  ===> 1010 + 0 + 0 ===> 1010 + 1010 000 = 101 1010
            }
            a = a << 1; // a左移一位 ===> 1010 0 继续左移 ===> 1010 00 继续左移 ===> 1010 000
            b = b >>> 1;// b无符号右移一位 ===> 0100，末尾是0 继续右移 ===> 0010，末尾是0 继续右移 ===> 0001
        }
        return res;
    }

    /**
     * 分
     *
     * @param a 一个
     * @param b b
     * @return int
     */
    public static int divide(int a, int b) {
        // 处理Integer.MIN_VALUE的问题，它的绝对值会溢出
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) { // 其他任何Integer类型的数来除以Integer.MIN_VALUE结果都是0，因为没有比它的绝对值相等或更大的
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            if (b == negNum(1)) {// Integer.MIN_VALUE➗-1 == Integer.MAX_VALUE，没办法最大了
                return Integer.MAX_VALUE;
            } else {
                int c = div(add(a, 1), b); // add(a,1)，绝对值是Integer.MAX_VALUE，避免溢出。先+1相除，然后算一下1和b的差，做个差
                // 9➗2=4，拆解为：10➗2=5(c)，然后5✖️2=10；然后9-10=-1，然后-1➗2=0；然后4+0=4，结果是4
                return add(c, div(minus(a, multi(c, b)), b));
            }
        } else {
            // 直接计算
            return div(a, b);
        }
    }

    /**
     * 用减法实现除法
     *
     * @param a 一个
     * @param b b
     * @return int
     */
    private static int div(int a, int b) {
        // 先把两个数都弄成符号相同的
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;

        int res = 0;
        // int的位数是31位，第一位是符号位，不动。
        for (int i = 30; i >= 0; i = minus(i, 1)) { // minus(1,1) ====> i--
            if ((x >> i) >= y) { // x右移i位，如果比y大，说明x在i位置上是1。res = res + 1左移到i位置上
                res = res | (1 << i); // |：有1则1
                x = minus(x, y << i); // 减去，进入下次循环
            }
        }
        // 如果两个数一个大于0一个小于0，则结果是res的相反数，否则就是res
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    private static boolean isNeg(int n) {
        return n < 0;
    }

    /**
     * 取相反数
     *
     * @param n n
     * @return int
     */
    private static int negNum(int n) {
        return add(~n, 1);// 取反，加一得到绝对值
    }

    public static void main(String[] args) {
        System.out.println(add(1, -10));
        System.out.println(minus(1, 10));
        int multi = multi(Integer.valueOf("1010", 2), Integer.valueOf("1001", 2));
        System.out.println(multi);
        System.out.println(Integer.toBinaryString(multi));
        System.out.println(divide(9,2));
    }
}
