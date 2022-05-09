package org.xinghe.algorithm.basics;

import java.util.Objects;

/**
 * 对数器
 *
 * @author 星河君❀❀ 2022/5/8 22:29
 * @see [相关类/方法]
 * @since [版本号]
 */
public class CompTest {

    /**
     * 生成一个最大长度不超过maxLength，最大值不超过maxValue的数组
     *
     * @param maxLength 最大长度
     * @param maxValue  最大价值
     * @return {@link int[]}
     */
    public static int[] createArrayWithRandomLengthAndMaxValue(int maxLength, int maxValue) {
        int length = (int) (Math.random() * maxLength);
        int[] arrays = new int[length];
        for (int i = 0; i < length; i++) {
            arrays[i] = (int) (Math.random() * maxValue);
        }
        return arrays;
    }


    /**
     * 生成随机数组，相邻数不相等
     *
     * @param maxLength 最大长度
     * @param maxValue  最大价值
     * @return {@link int[]}
     */
    public static int[] createArrayWithRandomLengthAndMaxValue1(int maxLength, int maxValue) {
        int length = (int) (Math.random() * maxLength);
        int[] arrays = new int[length];
        if (length > 0) {
            arrays[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < length; i++) {
                do {
                    arrays[i] = (int) (Math.random() * maxValue);
                } while (arrays[i] == arrays[i - 1]);
            }
        }
        return arrays;
    }


    /**
     * 判断数组是升序的
     *
     * @param arrays 数组
     * @return boolean
     */
    public static boolean isAscOrderArray(int[] arrays) {
        if (Objects.isNull(arrays) || arrays.length < 2) {
            return true;
        }
        int minValue = arrays[0];//默认第一个是最小值，如果后面的比它小，则不是升序
        for (int i = 1; i < arrays.length; i++) {
            if (minValue > arrays[i]) {
                return false;
            }
            minValue = Math.max(minValue, arrays[i]); // 把两者中的最大的赋值给它，用于下次比较
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arrays = {1, 2, 1, 2, 3, 4, 5};
        System.out.println(isAscOrderArray(arrays));

//        int[] arrayWithRandomLengthAndMaxValue = createArrayWithRandomLengthAndMaxValue(10, 100);
        int[] arrayWithRandomLengthAndMaxValue = createArrayWithRandomLengthAndMaxValue(4, 98);
        System.out.println("====");
    }
}
