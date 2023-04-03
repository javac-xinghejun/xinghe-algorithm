package org.xinghe.algorithm.dp;

/**
 * 斐波那契数列的四种写法
 *
 * @author 星河君❀❀ 2023/3/22 11:07
 * @see [相关类/方法]
 * @since [版本号]
 */
public class FbTest {
    /**
     * 常规写法，每次都需要计算
     *
     * @param i 我
     * @return int
     */
    public static int fb1(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1 || i == 2) {
            return 1;
        }

        return fb1(i - 1) + fb1(i - 2);
    }


    /**
     * 引入数组作为缓存，计算缓存过的数据，避免重复计算
     * 这就是所谓备忘录
     *
     * @param i 我
     * @return int
     */
    public static int fb2(int i) {
        if (i == 0) {
            return 0;
        }

        // 声明一个数组，把计算过的值存起来
        int[] ints = new int[i];
        return calTmp(ints, i);
    }

    private static int calTmp(int[] ints, int i) {
        if (i == 1 || i == 2) {
            return 1;
        }

        if (ints[i] != 0) {
            return ints[i];
        }
        ints[i] = calTmp(ints, i - 1) + calTmp(ints, i - 2);
        return ints[i];
    }

    /**
     * 已知数组的后面数据依赖前面的数据，直接计算即可
     * 这就是所谓DP table
     *
     * @param i 我
     * @return int
     */
    public static int fb3(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1 || i == 2) {
            return 1;
        }

        int[] ints = new int[i];
        ints[1] = 1;
        ints[2] = 2;
        for (int j = 3; j <= i; j++) {
            ints[j] = ints[j - 1] + ints[j - 2];
        }
        return ints[i];
    }


    /**
     * 不使用数据，类似快慢指针，不断赋值，最后返回结果
     *
     * @param i 我
     * @return int
     */
    public static int fb4(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1 || i == 2) {
            return 1;
        }

        int prev = 1, curr = 1;
        for (int j = 3; j <= i; j++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
