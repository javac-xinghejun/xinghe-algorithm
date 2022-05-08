package org.xinghe.algorithm.basics;

import java.util.Objects;

/**
 * 描述：有序数组中找num
 *
 * @author 星河君❀❀ 2022/5/8 22:50
 * @see [相关类/方法]
 * @since [版本号]
 */
public class FinderTest {
    /**
     * 在有序数组ints中找num
     *
     * @param ints 整数
     * @param num  全国矿工工会
     * @return boolean
     */
    public static boolean arraysContains(int[] ints, int num) {
        if (Objects.isNull(ints) || ints.length < 1) {
            return false;
        }

        int l = 0, r = ints.length - 1;
        while (l <= r) {
            int middleIndex = (l + r) / 2;
            int middleValue = ints[middleIndex];
            if (middleValue == num) {
                return true;
            } else if (middleValue < num) {
                l = middleIndex + 1;
            } else {
                r = middleIndex - 1;
            }
        }

        return false;
    }

    private static boolean arraysContainsClassic(int[] ints, int num) {
        if (Objects.isNull(ints) || ints.length < 1) {
            return false;
        }
        for (int anInt : ints) {
            if (anInt == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 6, 8, 9, 10, 12};
        System.out.println(arraysContains(array, 6));
        System.out.println(arraysContains(array, 7));
        System.out.println(arraysContains(array, 8));



    }
}
