package org.xinghe.algorithm.leetcode;

import org.xinghe.algorithm.basics.ListNode;

/**
 * https://leetcode.cn/problems/reorder-list/
 *
 * @author 星河君❀❀ 2022/5/9 20:10
 * @see [相关类/方法]
 * @since [版本号]
 */
public class ReorderListNodeTest {
    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        // 先截取后一半的链表，并反转
        ListNode postHalfList = getPostHalfList(head);
        ListNode reverse = reverse(postHalfList);

//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode current = dummy; // 记录链表移动的位置
        // 移动两个链表，拼接
        link(postHalfList,head);


    }

    private static void link(ListNode postHalfListReversed, ListNode head) {
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode current = dummy;

        while (postHalfListReversed != null && head != null){
            ListNode temp = postHalfListReversed.next;

            current.next = head;
            current = current.next;
            current.next = postHalfListReversed.next;
            current = current.next;

            current = temp;

            postHalfListReversed = postHalfListReversed.next;
            head = head.next;
        }
    }

    private static ListNode getPostHalfList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }

        }

        return slow.next;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode current = head; // 记录移动链表的指针
        while (current != null) {
            ListNode next = current.next;//记录下一个节点，避免链表断开
            current.next = pre; // 把前驱节点赋值给next，即：当前节点的下一个节点指向原来的前驱节点，实现反转
            pre = current; // 移动指针
            current = next;
        }

        return pre;
    }
}
