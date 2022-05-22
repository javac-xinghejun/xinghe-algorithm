package org.xinghe.algorithm.basics;

import org.xinghe.algorithm.datastructure.Node;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/10 22:00
 * @see [相关类/方法]
 * @since [版本号]
 */
public class NodeTest {

    /**
     * 反向节点
     * <p>
     * 需要注意的是，这么做能成功是因为Java操作的是值，而不是引用。即：每次其实操作的都是副本，而不是内存地址。
     * <p>
     * 为什么要返回一个节点？为的是避免JVM把没有引用的对象回收了。
     *
     * @param head 头
     * @return {@link Node}
     */
    public static Node reverseNode(Node head) {
        Node next = null, pre = null;
        while (head != null) {
            // 记录原来节点的下一个节点
            next = head.next;
            // 把原来节点的下一个节点指向为上一个节点
            head.next = pre;
            // 下面两步相当于把指针往后移动，以便于操作下一个节点
            // 把原来的节点赋值到前一个节点
            pre = head;
            // 把下一个节点赋值到原来的节点
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);

        Node node = reverseNode(n1);
        System.out.println(node.value);
    }
}
