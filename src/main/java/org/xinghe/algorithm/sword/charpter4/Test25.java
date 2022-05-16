package org.xinghe.algorithm.sword.charpter4;

import org.xinghe.algorithm.basics.Node;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/16 21:08
 * @see [相关类/方法]
 * @since [版本号]
 */
public class Test25 {
    public static Node<Integer> addNode(Node<Integer> head1, Node<Integer> head2) {
        Node<Integer> newHead1 = reverseNode(head1);
        Node<Integer> newHead2 = reverseNode(head2);

        Node<Integer> dummy = new Node<>(0);
        Node<Integer> sumNode = dummy; // 已经求和的最后一个节点，第一个位置是dummy哨兵位，默认从这里开始
        int carry = 0; // 标识是否有进位，初始值为0
        while (newHead1 != null || newHead2 != null) {
            int value1 = newHead1 == null ? 0 : newHead1.value;
            int value2 = newHead2 == null ? 0 : newHead2.value;
            int sum = value1 + value2 + carry; // 当前位置两个节点值的和，加上进位
            carry = sum >= 10 ? 1 : 0; // 是否有进位
            int unit = sum >= 10 ? sum - 10 : sum; // 两个数相加后的个位数
            Node<Integer> current = new Node<>(unit); // 当前求和位置上的新节点
            // 把current放到sumNode后面
            sumNode.next = current;
            // 移动到下一位，这里有三个链表，都需要移动到下一位
            sumNode = sumNode.next;

            newHead1 = newHead1 == null ? null : newHead1.next;
            newHead2 = newHead2 == null ? null : newHead2.next;
        }
        // 到这里就是最后一位数有进位了
        if (carry == 1){
            Node<Integer> node = new Node<>(1);
            sumNode.next = node;
        }
        // 哨兵的下一位就是结果的head
        return dummy.next;
    }

    /**
     * 反向节点
     * <p>
     * a <- b(current) -> c 记录当前节点的下一个节点current.next就是c
     * 1: a <- b(current) <- c  把下一个节点的变成上一个节点，反转第一步 current.next = pre
     * 2: a <- b <-c（current）
     *
     * @param head 头
     * @return {@link Node}<{@link Integer}>
     */
    private static Node<Integer> reverseNode(Node<Integer> head) {
        Node<Integer> pre = null;
        // 当前节点（当前指针指向的节点）
        Node<Integer> current = head;
        // 遍历
        while (current != null) {
            // 记录当前指针的下一个节点，避免后续操作导致链表断开
            Node<Integer> next = current.next;
            // 反转第一步：把当前节点的下一个节点指向到原来的上一个节点pre
            current.next = pre;
            // 反转第二步：移动当前指针：把当前指针赋值给pre，下一个节点赋值为当前指针
            pre = current;
            current = next;
        }
        return pre;
    }
}
