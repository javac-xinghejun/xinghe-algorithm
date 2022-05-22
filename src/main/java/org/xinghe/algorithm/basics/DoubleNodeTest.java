package org.xinghe.algorithm.basics;

import org.xinghe.algorithm.datastructure.DoubleNode;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/11 20:33
 * @see [相关类/方法]
 * @since [版本号]
 */
public class DoubleNodeTest {
    /**
     * 反向双向链表
     *
     * 这里可以看出为什么AQS每次都要CAS保证一下。
     *
     * @param head 头节点
     * @return {@link DoubleNode}
     */
    public static DoubleNode reverseDouble(DoubleNode head) {
        DoubleNode last = null, next = null;
        while (head != null) {
            // 1. 把原本指向下一个节点的，指向上一个节点
            // 2. 把原本指向上一个节点的，指向下一个节点
            // 3. 移动到下一个节点

            // 先把head的next记录下来
            next = head.next;

            // 再把head的next置为last  ---> 对应上面的1
            head.next = last;
            // 再把head的last置为next  ---> 对应上面的2
            head.last = next;

            // 下面两步对应上面的3
            // 再把last置为next
            last = head;
            // 移动到下一个节点
            head = next;
        }
        // 返回上一个，新的头结点
        return last;
    }

    public static void main(String[] args) {

        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);
        DoubleNode node4 = new DoubleNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node2.last = node1;
        node3.last = node2;
        node4.last = node3;

        DoubleNode reverseNode = reverseDouble(node1);
        System.out.println(reverseNode);
    }
}

