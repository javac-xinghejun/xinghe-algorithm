package org.xinghe.algorithm.basics;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/9 20:10
 * @see [相关类/方法]
 * @since [版本号]
 */
public class MyDequeTest<E> {
    int size;
    Node<E> head;
    Node<E> tail;


    class Node<E> {
        E value;
        Node<E> last;
        Node<E> next;

        Node() {
        }

        Node(E value, Node<E> next, Node<E> last) {
            this.value = value;
            this.next = next;
            this.last = last;
        }
    }

    void offerFirst(E e) {
        Node<E> current = new Node<>(e, null, null);
        if (head == null) {
            head = current;
            tail = current;
        } else {
            // 记录原来的head，当前节点的next指向head，原来head的last指向当前节点，把当前节点设置成head
            Node<E> oldHead = this.head;
            current.next = oldHead;
            oldHead.last = current;
            head = current;
        }
        size++;
    }

    void offerLast(E e) {
        Node<E> current = new Node<>(e, null, null);
        if (head == null) {
            head = current;
            tail = current;
        } else {
            // 记录原来的tail，原来的tail的next指向current，current指向tail
            Node<E> oldTail = this.tail;
            oldTail.next = current;
            current.last = oldTail;
            tail = current;
        }
    }

    E pollFirst() {
        if (head == null) {
            return null;
        }
        Node<E> oldHead = this.head;
        E value = head.value;

        Node<E> next = oldHead.next;
        next.last = null;
        oldHead = null;
        head = next;

        return value;
    }

    E pollLast() {
        if (head == null) {
            return null;
        }

        Node<E> oldTail = this.tail;
        E value = oldTail.value;

        Node<E> last = oldTail.last;
        oldTail = null;
        tail = last;

        return value;
    }


}
