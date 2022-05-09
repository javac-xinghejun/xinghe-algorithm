package org.xinghe.algorithm.basics;

import java.util.Objects;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/9 20:10
 * @see [相关类/方法]
 * @since [版本号]
 */
public class ArrayUtil {
    public static void printArray(int[] arrays) {
        if (Objects.isNull(arrays)) {
            return;
        }
        for (int array : arrays) {
            System.out.print(array + " ");
        }
        System.out.println();
    }
}
