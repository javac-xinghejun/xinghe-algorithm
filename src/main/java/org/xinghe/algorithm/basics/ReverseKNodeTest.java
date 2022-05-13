package org.xinghe.algorithm.basics;

/**
 * 描述 https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *
 * @author 星河君❀❀ 2022/5/12 22:41
 * @see [相关类/方法]
 * @since [版本号]
 */
public class ReverseKNodeTest {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 反向kgroup
     * <p>
     * input  : 1 2 3 5 6 8 9
     * k == 2
     * output : 2 1 5 3 8 6 9
     * <p>
     * count = 7
     * count / k + 1 = 4
     *
     * @param head 头
     * @param k    k
     * @return {@link ListNode}
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        boolean hasNext = true;
        while (hasNext) {
            ListNode next = head.next;
            head = next;
            hasNext = next != null ? true : false;
            count++;
        }
        if (count < k) {
            return head;
        }
        int page = count / k + 1;
        ListNode resultNode = null;
        for (int i = 0; i < page; i++) {
            ListNode first, last = null;
            ListNode pageHead = reverseListNode(head, k);
            if (i == 0) {
                resultNode = pageHead;
            }


        }
        return resultNode;
    }

    private ListNode reverseListNode(ListNode head, int k) {
        ListNode next, last = null;
        while (head != null && k >= 0) {
            // 获取下一个节点
            next = head.next;
            // 头结点的下一个节点指向上一个（反转）
            head.next = last;
            // 把head当下一个节点
            last = head;
            // 指针移动到next上去，循环下一次
            head = next;
            k--;
        }
        return last;
    }
}
