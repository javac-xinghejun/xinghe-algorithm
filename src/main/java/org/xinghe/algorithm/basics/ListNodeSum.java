package org.xinghe.algorithm.basics;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/14 15:25
 * @see [相关类/方法]
 * @since [版本号]
 */
public class ListNodeSum {

    public void listNodeSum(ListNode head1, ListNode head2) {
        int length1 = getListNodeLength(head1);
        int length2 = getListNodeLength(head2);

        ListNode longer = null, shorter = null;
        int longerLength = 0,shorterLength = 0;
        if (length1 >= length2) {
            longer = head1;
            shorter = head2;
            longerLength = length1;
            shorterLength = length2;
        } else {
            longer = head2;
            shorter = head1;
            longerLength = length2;
            shorterLength = length1;
        }
        longer = reverse(longer);
        shorter = reverse(shorter);

        // 遍历
        for (int i = 0; i < longerLength; i++) {
            ListNode iNode1 = getINode(longer,i);
            int val1 = iNode1.val;
            int val2 = 0;
            if (shorterLength>i){
                ListNode iNode2 = getINode(shorter, i);
                val2 = iNode2.val;
            }

            // 新节点的第i个值
            int val = val1 + val2;
            // 判断是不是需要进位
            int i1 = val / 10; // 商，是否需要进位
            int i2 = val % 10; // 余数，就是这个节点的值

        }

    }

    private ListNode getINode(ListNode head, int i) {
        for (int j = 0; j < i; j++) {
            head = head.next;
        }
        return head;
    }

    /**
     * 得到列表节点长度
     *
     * @param head 头
     * @return int
     */
    private int getListNodeLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    /**
     * 反向
     *
     * @param head 头
     * @return {@link ListNode}
     */
    private ListNode reverse(ListNode head) {
        ListNode next, pre = null;
        while (head != null) {
            // head的下一个节点
            next = head.next;
            // 上一个节点赋值为head的下一个节点，这里就是反转了
            head.next = pre;
            // 把head赋值给pre，next赋值给head，完成指针移动
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.println(2 / 10); // 0
        System.out.println(2 % 10); // 2
        System.out.println(12 / 10); // 1
        System.out.println(12 % 10); // 2
    }
}

