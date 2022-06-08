package org.xinghe.algorithm.sword.charpter1;

/**
 * 输入两个表示二进制的字符串，请计算它们的和，并以二进制字符串的形式输出。例如，输入的二进制字符串分别是"11"和"10"，则输出"101"。
 *
 * @author 星河君❀❀ 2022/5/9 20:10
 * @see [相关类/方法]
 * @since [版本号]
 */
public class Test2 {
    /**
     * 这个解法有问题：题干并没有说是int，可能溢出
     *
     * @param bi1 bi1
     * @param bi2 bi2
     * @return int
     */
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

    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 | j >= 0) {

            int ai = 0, bi = 0;
            if (i >= 0) {
                char ca = a.charAt(i);
                int i1 = ca - '0';
                ai = i1;
            }
            if (j >= 0) {
                char ba = b.charAt(i);
                int i1 = ba - '0';
                bi = i1;
            }

            int sum = ai + bi + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;


            res = res.append(sum);
            i--;
            j--;
        }
        if (carry == 1) {
            res.append(1);
        }

        return res.reverse().toString();
    }

    /**
     * 模拟十进制加法
     *
     * @param bi1 bi1
     * @param bi2 bi2
     * @return {@link String}
     */
    public static String add1(String bi1, String bi2) {
        String res = "";
        int length1 = bi1.length();
        int length2 = bi2.length();
        // 这个用来循环
        int l = Math.max(length2, length1);
        int offset1 = l - length1;
        int offset2 = l - length2;
        String[] s1 = bi1.split("");
        String[] s2 = bi2.split("");
        // 从最后一位开始算，一直到第一位，没有的按0补齐
        int lastCurry = 0;
        for (int i = l - 1; i >= 0; i--) {
            String s1Temp = i - offset1 < 0 ? "0" : s1[i - offset1];
            String s2Temp = i - offset2 < 0 ? "0" : s2[i - offset2];
            int i1 = Integer.parseInt(s1Temp);
            int i2 = Integer.parseInt(s2Temp);


            int i3 = i1 ^ i2;// 无进位信息
            int i4 = i3 ^ lastCurry;// 继续无进位相加，这个值要放到结果的字符串中

//            int i5 = i1 & i2;// 当前位的进位信息
//            // 当前位的值和上一位进位相加是否有进位，都为1则为1
//            int currentCurry = i4 & lastCurry;
//            // 当前位如果有进位，lastCurry一定进位；当前位如果没有进位，只有在当前位计算结果为1时，lastCurry才进位
//            lastCurry = i5 | currentCurry;
            lastCurry = i1 + i2 + lastCurry >= 2 ? 1 : 0;
            res = String.valueOf(i4).concat(res);
            System.out.println("curry:" + lastCurry);
            System.out.println("res:" + res);
            System.out.println("----");

        }
        // 如果最后有进位信息，需要加上
        if (lastCurry == 1) {
            res = String.valueOf(lastCurry).concat(res);
        }

        return res;
    }

    public static void main(String[] args) {
        String bi1 = "1010";
        String bi2 = "1011";
        System.out.println(bi1);
        System.out.println(bi2);
        System.out.println("----");
        System.out.println(add1(bi1, bi2));

//        System.out.println(1 ^ 1);
//        System.out.println(1 & 1);
//        System.out.println(1 ^ 0);
//        System.out.println(1 & 0);
//        System.out.println(1 | 1);
//        System.out.println(1 | 0);

    }
}
