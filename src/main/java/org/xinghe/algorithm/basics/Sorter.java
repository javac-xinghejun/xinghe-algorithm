package org.xinghe.algorithm.basics;

import java.util.Objects;

/**
 * @author 星河君❀❀ 2022/5/6 18:11
 * @see [相关类/方法]
 * @since [版本号]
 */
public class Sorter {

    /**
     * 选择排序
     * 从0到length-1遍历，把最小的放左边
     * 从1到length-1遍历，把最小的放左边
     * ...
     * 一直到最后一个元素
     *
     * @param arrays 数组
     * @return
     */
    private static void selectSort(int[] arrays) {
        if (Objects.isNull(arrays) || arrays.length < 2) {
            return;
        }

        int length = arrays.length;
        for (int i = 0; i <= length - 1; i++) {
            int minValueIndex = i; // 最小值的索引位置
            // 从 i+1 到 length-1 位置循环，如果有比i位置上的值更小的，则把最小值索引更新掉
            for (int j = i + 1; j <= length - 1; j++) {
                if (arrays[j] < arrays[minValueIndex]) {
                    minValueIndex = j;
                }
            }
            // 把i位置的值和最小值索引位置上的值交换
            swap(arrays, i, minValueIndex);
        }
    }

    /**
     * 冒泡排序
     * 从0到length-1遍历，如果左边的比右边的小，则交换位置。即：相邻交换
     *
     * @param arrays 数组
     */
    private static void bubbleSort(int[] arrays) {
        if (Objects.isNull(arrays) || arrays.length < 2) {
            return;
        }
        int length = arrays.length;
        // 从0开始遍历，保证可以遍历length-1遍
        for (int i = 0; i < length; i++) {
            // 从最后一个往第0个遍历，如果右边比左边大，则交换位置
            for (int j = length - 1; j > 0; j--) {
                if (arrays[j] < arrays[j - 1]) {
                    swap(arrays, j - 1, j);
                }
            }
        }
    }

    /**
     * 插入排序
     * 每个数据跟前一个比，如果比前一个小，则两两交换。同样是两个两个交换
     *
     * @param arrays 数组
     */
    private static void insertSort(int[] arrays) {
        if (Objects.isNull(arrays) || arrays.length < 2) {
            return;
        }
        int length = arrays.length;
        for (int i = 0; i < length; i++) {
            // 从1开始，因为0 位置前面没有数据，不需要比较
            for (int j = 1; j < length; j++) {
                if (arrays[j - 1] > arrays[j]) {
                    swap(arrays, j - 1, j);
                }
            }
        }
    }

    /**
     * 排序
     * 从i往后遍历，任何一个比i位置小的数据，和i交换位置
     *
     * @param arrays 数组
     */
    private static void mySort(int[] arrays) {
        if (Objects.isNull(arrays) || arrays.length < 2) {
            return;
        }
        int length = arrays.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arrays[i] > arrays[j]) {
                    swap(arrays, i, j);
                }
            }
        }
    }

    private static void swap(int[] arrays, int i, int j) {
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    private static void printArray(int[] arrays) {
        if (Objects.isNull(arrays)) {
            return;
        }
        for (int array : arrays) {
            System.out.print(array + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {10, 2, 3, 8, 9, 7, 59, 8, 2, 4};
        printArray(array);
//        selectSort(array);
//        bubbleSort(array);
//        insertSort(array);
        mySort(array);
        printArray(array);
    }
}
