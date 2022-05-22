package org.xinghe.algorithm.sword.charpter4;

import org.xinghe.algorithm.datastructure.ListNode;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/9 20:10
 * @see [相关类/方法]
 * @since [版本号]
 */
public class Test27 {
    /**
     * 是否是回文链表：
     * 1->2->3->2->1 true
     * 1->2 false
     *
     * @param head 头
     * @return boolean
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (slow != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        ListNode postHalfListNode = slow.next;
        ListNode reverse = reverse(postHalfListNode);
        while (reverse != null && head != null) {
            if (reverse.val != head.val) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }

        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode postHalfList = slow.next;
        if (fast.next != null) {
            postHalfList = slow.next.next;
        }
        slow.next = null;

        return equals(postHalfList, reverse(head));
    }

    private boolean equals(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null && head2 == null;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        one.next = new ListNode(2);
        one.next.next = new ListNode(3);
        System.out.println(new Test27().isPalindrome2(one));

        ListNode two = new ListNode(1);
        two.next = new ListNode(2);
        two.next.next = new ListNode(3);
        two.next.next.next = new ListNode(2);
        two.next.next.next.next = new ListNode(1);
        System.out.println(new Test27().isPalindrome2(two));

        ListNode three = new ListNode(3);
        System.out.println(new Test27().isPalindrome2(three));
    }
}
