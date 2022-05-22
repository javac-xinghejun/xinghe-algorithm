package org.xinghe.algorithm.leetcode;

import org.xinghe.algorithm.datastructure.TreeNode;

/**
 * 求树的最大深度
 *
 * @author 星河君❀❀ 2022/5/22 16:13
 * @see [相关类/方法]
 * @since [版本号]
 */
public class MaxLengthTest {
    public static int getMaxLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getMaxLength(root.left), getMaxLength(root.right)) + 1;
    }
}
