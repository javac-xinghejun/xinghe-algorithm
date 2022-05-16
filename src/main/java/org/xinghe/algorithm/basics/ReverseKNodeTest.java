package org.xinghe.algorithm.basics;

/**
 * 描述 https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *
 * @author 星河君❀❀ 2022/5/12 22:41
 * @see [相关类/方法]
 * @since [版本号]
 */
public class ReverseKNodeTest {

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
        ListNode start = head;
        // 第一组
        ListNode end = getEndNode(start, k);
        if (end == null) {
            return head;
        }
        head = end;
        // 第一组反转
        reverse(start, end);
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getEndNode(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }

        return head;
    }

    private ListNode getEndNode(ListNode start, int k) {

        while(--k != 0 && start != null){
            start = start.next;
        }
        return start;

    }

    private void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode current = start;
        ListNode pre = null, next = null;
        while (current != end) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        start.next = end;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        ListNode node1 = new ReverseKNodeTest().reverseKGroup(node, 2);
        System.out.println(node1);
    }

}
