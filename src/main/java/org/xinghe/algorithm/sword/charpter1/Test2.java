package org.xinghe.algorithm.sword.charpter1;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/9 20:10
 * @see [相关类/方法]
 * @since [版本号]
 */
public class Test2 {
    public static int add(String bi1, String bi2) {
        Integer a = Integer.valueOf(bi1, 2);
        Integer b = Integer.valueOf(bi2, 2);

        int r = a;
        int curry = 1;
        while (curry != 0) {
            int i = a ^ b;
            curry = (a & b) >> 1;
            r = r + i;
        }

        String s = Integer.toBinaryString(r);
        System.out.println(s);
        return r;
    }
}
