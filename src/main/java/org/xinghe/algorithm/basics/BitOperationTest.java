package org.xinghe.algorithm.basics;

/**
 * @author 星河君❀❀ 2022/5/6 09:35
 * @see [相关类/方法]
 * @since [版本号]
 */
public class BitOperationTest {

    /**
     * 打印int数据的二进制
     *
     * @param num int
     */
    private static void printBit(int num) {
        for (int i = 31; i >= 0; i--) {
            int i1 = num & (1 << i); // 1 左移 i 位，和num进行一个&与运算，如果结果是0，则打印0，否则打印1
            System.out.print(i1 == 0 ? "0" : "1");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int i = 10;
        System.out.println("i : 10");
        printBit(i);
        int leftMove = i << 3;
        System.out.println("leftMove : ");
        printBit(leftMove);
        int rightMove = i >> 3;
        System.out.println("rightMove : ");
        printBit(rightMove);
        int unsignRightMove = i >>> 3;
        System.out.println("unsignRightMove : ");
        printBit(unsignRightMove);

        System.out.println("===========");
        System.out.println("i : 10");
        printBit(i);
        int j = -10;
        System.out.println("j : -10");
        printBit(j);

        int or = i | j;
        System.out.println(" i | j : ");
        printBit(or);
        int and = i & j;
        System.out.println("i & j : ");
        printBit(and);
        int xor = i ^ j;
        System.out.println(" i ^ j : ");
        printBit(xor);

        int neg = ~ i;
        System.out.println(" ~ i : ");
        printBit(neg);


        System.out.println("演示反码、补码");


        printBit(10);

        printBit(-10);

        printBit(neg);
        printBit(neg + 1);
    }
}
