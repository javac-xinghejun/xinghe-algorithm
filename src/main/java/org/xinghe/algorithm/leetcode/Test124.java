package org.xinghe.algorithm.leetcode;

import org.xinghe.algorithm.datastructure.TreeNode;

/**
 * 描述
 *
 * @author 星河君❀❀ 2023/3/21 15:01
 * @see [相关类/方法]
 * @since [版本号]
 */
public class Test124 {
    public int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = Math.max(0,maxPathSum(root.left));
        int right = Math.max(0,maxPathSum(root.right));

        return left + right + root.val;
    }
}
