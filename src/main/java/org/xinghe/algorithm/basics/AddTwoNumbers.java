package org.xinghe.algorithm.basics;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/16 20:43
 * @see [相关类/方法]
 * @since [版本号]
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
//        head1 = reverseNode(head1);
//        head2 = reverseNode(head2);

        ListNode dummy = new ListNode(0);
        ListNode sumNode = dummy; // 已经求和的最后一个节点，第一个位置是dummy哨兵位，默认从这里开始
        int carry = 0; // 标识是否有进位，初始值为0
        while (head1 != null || head2 != null) {
            int value1 = head1 == null ? 0 : head1.val;
            int value2 = head2 == null ? 0 : head2.val;
            int sum = value1 + value2 + carry; // 当前位置两个节点值的和，加上进位
            carry = sum >= 10 ? 1 : 0; // 是否有进位
            int unit = sum >= 10 ? sum - 10 : sum; // 两个数相加后的个位数
            ListNode current = new ListNode(unit); // 当前求和位置上的新节点
            // 把current放到sumNode后面
            sumNode.next = current;
            // 移动到下一位，这里有三个链表，都需要移动到下一位
            sumNode = sumNode.next;

            head1 = head1 == null ? null : head1.next;
            head2 = head2 == null ? null : head2.next;
        }
        // 到这里就是最后一位数有进位了
        if (carry == 1) {
            ListNode node = new ListNode(1);
            sumNode.next = node;
        }
        // 哨兵的下一位就是结果的head
        ListNode next = dummy.next;
        return next;
    }

    private ListNode reverseNode(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(2);
        one.next = new ListNode(4);
        one.next.next = new ListNode(9);
        ListNode two = new ListNode(5);
        two.next = new ListNode(6);
        two.next.next = new ListNode(4);
        two.next.next.next = new ListNode(9);

        ListNode node = new AddTwoNumbers().addTwoNumbers(one, two);
        System.out.print(node.val);
        System.out.print(node.next.val);
        System.out.print(node.next.next.val);
        System.out.println();
    }
}
