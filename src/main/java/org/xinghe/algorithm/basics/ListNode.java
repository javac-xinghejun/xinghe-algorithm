package org.xinghe.algorithm.basics;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/14 15:19
 * @see [相关类/方法]
 * @since [版本号]
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
