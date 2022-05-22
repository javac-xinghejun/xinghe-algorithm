package org.xinghe.algorithm.basics;

import org.xinghe.algorithm.datastructure.Node;

/**
 * 使用单链表实现队列
 *
 * @author 星河君❀❀ 2022/5/9 20:10
 * @see [相关类/方法]
 * @since [版本号]
 */
public class MyQueueTest<T> {

    Node<T> node;
    int size;

    Node<T> head;
    Node<T> tail;

    public boolean isEmpty() {
        return size == 0;
    }

    public void offer(T t) {
        Node<T> current = new Node<>(t, null);
        // 如果head为空，直接把head和tail都指向当前的节点即可
        if (head == null) {
            head = current;
            tail = current;
        } else {
            // 原来的tail记录一下
            Node<T> oldTail = this.tail;
            // 原来的tail节点的next指向current
            oldTail.next = current;
            // 把尾节点指向当前节点
            this.tail = current;
        }
        // 队列size+1
        size++;
    }

    public T poll() {
        if (head == null) {
            return null;
        }
        // 先把head的next节点存下来
        Node<T> next = head.next;
        // 然后把head移动到next
        head = next;
        size--;
        return head.value;
    }

    public T peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }





}
