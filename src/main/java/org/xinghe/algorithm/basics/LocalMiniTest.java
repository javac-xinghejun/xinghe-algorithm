package org.xinghe.algorithm.basics;

import java.util.Objects;

/**
 * 局部最小：一个数组中，某个数字比左右都小就是局部最小。[0] < [1] 则 0位置局部最小；[n-2]>[n-1]则 n-1位置局部最小
 * 数组：无序，任意两个相邻的数字不相等
 *
 * @author 星河君❀❀ 2022/5/9 21:25
 * @see [相关类/方法]
 * @since [版本号]
 */
public class LocalMiniTest {
    /**
     * 返回局部最小值的索引位置，有一个即可
     * <p>
     * 原理：这个数组，如果长度超过2，那么必然存在某个段是V型。先取中间的值(M)，如果L < M,
     *
     * @param array 数组
     * @return int
     */
    private static int getLocalMiniIndex(int[] array) {
        if (Objects.isNull(array) || array.length < 1) {
            return -1;
        }
        if (array.length == 1 || array[0] < array[1]) {
            return 0;
        }
        if (array[array.length - 1] < array[array.length - 2]) {
            return array.length - 1;
        }

        int l = 1, r = array.length - 2;
        int index = -1;
        while (l <= r) {
            int middleIndex = (l + r) / 2;
            int middleValue = array[middleIndex];
            if (middleValue < array[middleIndex + 1] && middleValue < array[middleIndex - 1]) {
                index = middleIndex;
                break;
            } else if (middleValue > array[middleIndex + 1] && middleValue < array[middleIndex - 1]) {
                l = middleIndex + 1;
            } else {
                r = middleIndex - 1;
            }
        }

        return index;
    }

    private static int getLocalMiniIndexLoop(int[] array) {
        if (Objects.isNull(array) || array.length < 2) {
            return -1;
        }
        if (array[0] < array[1]) {
            return 0;
        }
        if (array[array.length - 1] < array[array.length - 2]) {
            return array.length - 1;
        }

        for (int i = 1; i < array.length - 1; i++) {
            if (array[i - 1] > array[i] && array[i] < array[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

//        int[] ints = {29};
//        int index = 0;
//        System.out.println(check(ints, index));

        int testTimes = 10000;
        int maxLength = 10;
        int maxValue = 100;
        boolean allSuccess = true;
        for (int i = 0; i < testTimes; i++) {
            int[] array = CompTest.createArrayWithRandomLengthAndMaxValue1(maxLength, maxValue);
            int localMiniIndex = getLocalMiniIndex(array);
            if (!check(array, localMiniIndex)) {
                ArrayUtil.printArray(array);
                System.out.println(localMiniIndex);
                System.out.println("========");
                allSuccess = false;
                break;
            }
        }

        System.out.println(allSuccess ? "全部成功" : "失败了！");


//        int[] ints = {81, 30, 18, 62, 72, 23, 28, 52};
//        int localMiniIndex = getLocalMiniIndex(ints);
//        System.out.println(localMiniIndex);
    }

    private static boolean check(int[] array, int index) {
        if (Objects.isNull(array) || array.length < 1) {
            return index == -1;
        }
        if (array.length == 1) {
            return index == 0;
        }

        if (index == 0) {
            return array[0] < array[1];
        }
        if (index == array.length - 1) {
            return array[array.length - 1] < array[array.length - 2];
        }

        boolean left = index > 0 && array[index] < array[index - 1];
        boolean right = index < array.length - 1 && array[index] < array[index + 1];

        return left && right;

    }
}
