package org.xinghe.algorithm.leetcode;

import org.xinghe.algorithm.datastructure.ListNode;
import org.xinghe.algorithm.util.ListNodeUtil;

/**
 * https://leetcode.cn/problems/rotate-list/
 *
 * @author 星河君❀❀ 2022/5/9 20:10
 * @see [相关类/方法]
 * @since [版本号]
 */
public class RetateTest {
    public static ListNode rotateRight(ListNode head, int k) {
        // 没有节点或只有一个节点时
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        ListNode tail = current;
        // 尾节点指向头节点，形成环
        tail.next = head;
//        head                tail head                tail
//        1 -> 2 -> 3 -> 4 -> 5 -> 1 -> 2 -> 3 -> 4 -> 5
//                                 head                tail
//        X    X    1 -> 2 -> 3 -> 4 -> 5 -> 1 -> 2 -> 3 -> 4 -> 5
//        1 -> 2 -> 3 -> 4 -> 5 -> 1 -> 2 -> 3 -> 4 -> 5
//
//        相当于tail往左移动k位，当前位置往右移动length-k % length位置，length是链表长度
//        应该从3后面截断
        int position =length - k % length;
        if (position == length){
            return head;
        }
        ListNode temp = tail; // 用于移动的指针，用tail移动，目的是更好地找到head
        while (position-- > 0) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;

        return head;
    }

    /**
     * 反转，右移，然后反转。性能差。
     *
     * @param head 头
     * @param k    k
     * @return {@link ListNode}
     */
    public static ListNode rotate(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        // reverse
        ListNode reverse = ListNodeUtil.reverse(head);
        ListNode cur = reverse;
        while (cur.next != null) {
            cur = cur.next;
        }


        ListNode tail = cur;
        tail.next = reverse;

        ListNode temp = tail;
        for (int i = 0; i < k; i++) {
            temp = temp.next;
        }
        ListNode newHead = temp.next;
        temp.next = null;
        ListNode reverse1 = ListNodeUtil.reverse(newHead);
        return reverse1;
    }


    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        one.next = new ListNode(2);
        one.next.next = new ListNode(3);
        one.next.next.next = new ListNode(4);
        one.next.next.next.next = new ListNode(5);
        int k = 2;
        // 1 -> 2 -> 1
        // >> 1
        // 2 -> 1 -> 2

        ListNode listNode = rotateRight(one, k);
        System.out.println(ListNodeUtil.getListNodeVal(listNode));
    }

}
