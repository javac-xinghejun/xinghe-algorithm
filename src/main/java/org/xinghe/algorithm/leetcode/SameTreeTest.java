package org.xinghe.algorithm.leetcode;

import org.xinghe.algorithm.datastructure.TreeNode;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/22 15:50
 * @see [相关类/方法]
 * @since [版本号]
 */
public class SameTreeTest {
    /**
     * 是一样树
     *
     * 遍历每一个节点进行判断
     *
     * @param p p
     * @param q q
     * @return boolean
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // 两个有一个是null，另一个不是，那么肯定不是
        if (p == null ^ q == null) {
            return false;
        }
        // 两个都为空
        if (p == null && q == null) {
            return true;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
