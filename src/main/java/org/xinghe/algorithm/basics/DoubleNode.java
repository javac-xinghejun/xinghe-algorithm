package org.xinghe.algorithm.basics;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/9 20:10
 * @see [相关类/方法]
 * @since [版本号]
 */
public class DoubleNode<E> {
    E value;
    DoubleNode<E> last;
    DoubleNode<E> next;

    DoubleNode() {
    }

    DoubleNode(E value) {
        this.value = value;
    }

    DoubleNode(E value, DoubleNode<E> next, DoubleNode<E> last) {
        this.value = value;
        this.next = next;
        this.last = last;
    }
}
