package org.xinghe.algorithm.basics;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/16 21:12
 * @see [相关类/方法]
 * @since [版本号]
 */
public class MergeNodeTest {
    public ListNode mergeNode(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;// 记录遍历的指针位置
        // 两个都为空是跳出循环
        while (!((head1 == null) && (head2 == null))) {
            int val;
            boolean move1 = false, move2 = false;
            if (head1 == null) {
                val = head2.val;
                move2 = true;
            } else if (head2 == null) {
                val = head1.val;
                move1 = true;
            } else {
                if (head1.val <= head2.val) {
                    val = head1.val;
                    move1 = true;
                } else {
                    val = head2.val;
                    move2 = true;
                }
            }

            ListNode current = new ListNode(val);
            System.out.println(current.val);
            node.next = current;
            node = node.next;
            if (move1) {
                head1 = head1 == null ? null : head1.next;
            }
            if (move2) {
                head2 = head2 == null ? null : head2.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        one.next = new ListNode(2);
        one.next.next = new ListNode(4);

        ListNode two = new ListNode(1);
        two.next = new ListNode(3);
        two.next.next = new ListNode(4);
        ListNode node = new MergeNodeTest().mergeNode(one, two);
        System.out.print(node.val);
        System.out.print(node.next);
        System.out.print(node.next.next);
        System.out.print(node.next.next.next);
    }
}
