package org.xinghe.algorithm.basics;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/9 20:10
 * @see [相关类/方法]
 * @since [版本号]
 */
public class Node<T> {
    T value;
    Node<T> next;

    Node(T t) {
        this.value = value;
    }

    Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
}