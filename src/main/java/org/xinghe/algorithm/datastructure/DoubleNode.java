package org.xinghe.algorithm.datastructure;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/9 20:10
 * @see [相关类/方法]
 * @since [版本号]
 */
public class DoubleNode<E> {
    public E value;
    public DoubleNode<E> last;
    public DoubleNode<E> next;

    public DoubleNode() {
    }

    public DoubleNode(E value) {
        this.value = value;
    }

    public DoubleNode(E value, DoubleNode<E> next, DoubleNode<E> last) {
        this.value = value;
        this.next = next;
        this.last = last;
    }
}
