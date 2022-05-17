package org.xinghe.algorithm.sword.charpter4;

import org.xinghe.algorithm.basics.ListNode;

/**
 * 给定一个链表，链表中节点的顺序是L0→L1→L2→…→Ln-1→Ln，
 * 请问如何重排链表使节点的顺序变成L0→Ln→L1→Ln-1→L2→Ln-2→…？
 * 例如，输入图4.12（a）中的链表，重排之后的链表如图4.12（b）所示。
 *
 * @author 星河君❀❀ 2022/5/9 20:10
 * @see [相关类/方法]
 * @since [版本号]
 */
public class Test26 {
    public static ListNode reorderNode(ListNode head) {
        if (head == null) {
            return null;
        }
        // 后半段
        ListNode postHalfList = getHalfList(head);
        // 反转后半段
        ListNode reverse = reverse(postHalfList);
        // 拼接
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp != null && reverse != null) {
            // 当前节点
            ListNode current = head;
            // 拼接前半段的节点
            temp.next = current;
            // 移动temp的指针
            temp = temp.next;
            // 移动head的指针
            head = head.next;
            if (temp != null){
                ListNode nodeAfterCurrent = reverse;
                // temp的下一个节点指向它
                temp.next = nodeAfterCurrent;
                // 移动
                reverse = reverse.next;
                // 再次移动temp的指针
                temp = temp.next;
            }
        }

        return dummy.next;

    }

    private static int getNodeLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    private static ListNode getHalfList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        ListNode halfList = slow.next;
        return halfList;
    }

    private static ListNode reverse(ListNode head) {
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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode listNode = reorderNode(head);
        String s = "";
        while (listNode != null) {
            s = s.concat(listNode.val + "");
            listNode = listNode.next;
        }
        System.out.println(s);

    }
}
