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

    public static int multi(int a,int b){
        // 待定
    }

    public static void main(String[] args) {
        System.out.println(add(1, -10));
        System.out.println(minus(1, 10));
    }
}
