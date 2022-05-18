package org.xinghe.algorithm.basics;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/9 20:10
 * @see [相关类/方法]
 * @since [版本号]
 */
public class LongBitMap {
    // 思想：一个long类型的数字有64bit（即8bytes），
    // 那么一个long的bit位可以用1来表示对应位的数字存在于map中。
    // 比如 10，可以用000000…… 10 0000 0000，即第10个bit上是1

    private final long[] bits;

    public LongBitMap() {
        bits = new long[1024]; // 实际容量是1024 * 64个数字。
    }

    public LongBitMap(int size) throws Exception {
        if (size < 1) {
            throw new Exception("size不能小于1");
        }
        bits = new long[size];
    }

    public void add(long num) {
        // 查看号段，即在数组的第几个位置上
        int index = (int) num / 64;
        // 确定这个数字在l的第几个bit位上
        long position = num % 64;
        // 先把position的值改成1
        long i = 1L << position;
        // 然后用这个数和原来的index进行|运算
        bits[index] |= i;
        // 等价于 bits[index] = bits[index] | i;
    }

    public boolean contain(long num) {
        int index = (int) num / 64;
        long position = num % 64;
        // 判断这个位置是不是1
        long rightMove = bits[index] >>> position;
//        boolean result = (rightMove & 1L) == 1L;
        boolean result = (rightMove & 1) == 1;
        return result;
    }

    public static void main(String[] args) {
        LongBitMap bitMap = new LongBitMap();
        bitMap.add(128L + 62L);
        boolean contain = bitMap.contain(128L + 62L);
        System.out.println(contain);

    }
}
