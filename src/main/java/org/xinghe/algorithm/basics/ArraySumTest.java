package org.xinghe.algorithm.basics;

import java.util.Objects;

/**
 * @author 星河君❀❀ 2022/5/7 21:57
 * @see [相关类/方法]
 * @since [版本号]
 */
public class ArraySumTest {
    public static void main(String[] args) {
        int[] arrays = {1, 1, 1, 1, 1, 1};
        System.out.println(sum(arrays, 1, 2));
        System.out.println(sum(arrays, 1, 5));
        System.out.println(sum(arrays, 0, 5));
    }

    private static int sum(int[] arrays, int startIndex, int endIndex) {
        if (Objects.isNull(arrays) || startIndex < 0 || endIndex > arrays.length - 1 || startIndex > endIndex) {
            throw new ArrayIndexOutOfBoundsException("数组为空，或越界！");
        }
        int indexSum[] = new int[arrays.length];
        int sumTemp = 0;
        for (int i = 0; i < arrays.length; i++) {
            sumTemp = sumTemp + arrays[i];
            indexSum[i] = sumTemp;
        }
        if (startIndex == 0) {
            return indexSum[endIndex];
        }

        return indexSum[endIndex] - indexSum[startIndex - 1];
    }



}
