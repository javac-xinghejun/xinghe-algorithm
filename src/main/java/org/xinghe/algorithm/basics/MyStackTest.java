package org.xinghe.algorithm.basics;

import org.xinghe.algorithm.datastructure.Node;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/9 20:10
 * @see [相关类/方法]
 * @since [版本号]
 */
public class MyStackTest<T> {

    int size;
    Node<T> head;

    public T push(T t) {

        return t;
    }

    public T pop() {

        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
