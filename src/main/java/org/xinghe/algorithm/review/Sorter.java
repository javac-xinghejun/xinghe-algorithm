package org.xinghe.algorithm.review;

import org.xinghe.algorithm.basics.ArrayUtil;

/**
 * 三种排序的实现
 *
 * @author 星河君❀❀ 2022/5/9 20:10
 * @see [相关类/方法]
 * @since [版本号]
 */
public class Sorter {
    /**
     * 选择排序
     *
     * @param arrays 数组
     */
    public static void selectionSort(int[] arrays) {
        if (arrays == null || arrays.length < 2) {
            return;
        }

        for (int i = 0; i < arrays.length - 1; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[minValueIndex] > arrays[j]) {
                    minValueIndex = j;
                }
            }
            swap(arrays, i, minValueIndex);
        }
    }

    private static void swap(int[] arrays, int i, int j) {
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    public static void main(String[] args) {
        int arrays[] = new int[]{1, 5, 2, 3, 9, 6, 0, 4};
        selectionSort(arrays);
        ArrayUtil.printArray(arrays);
    }
}
