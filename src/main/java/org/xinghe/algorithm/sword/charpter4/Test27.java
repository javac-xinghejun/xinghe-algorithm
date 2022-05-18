package org.xinghe.algorithm.sword.charpter4;

import org.xinghe.algorithm.basics.ListNode;

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
        while (slow != null && fast.next != null){
            fast = fast.next;
            slow = slow.next;
            if (fast.next != null){
                fast = fast.next;
            }
        }
        ListNode postHalfListNode = slow.next;
        ListNode reverse = reverse(postHalfListNode);
        while (reverse != null && head != null){
            if (reverse.val != head.val){
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        while (current != null){
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
        System.out.println(new Test27().isPalindrome(one));

        ListNode two = new ListNode(1);
        two.next = new ListNode(2);
        two.next.next = new ListNode(3);
        two.next.next.next = new ListNode(2);
        two.next.next.next.next = new ListNode(1);
        System.out.println(new Test27().isPalindrome(two));

        ListNode three = new ListNode(3);
        System.out.println(new Test27().isPalindrome(three));
    }
}
