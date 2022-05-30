package org.xinghe.algorithm.leetcode;

import org.xinghe.algorithm.datastructure.TreeNode;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/30 19:58
 * @see [相关类/方法]
 * @since [版本号]
 */
public class Test98 {
    static class Info {
        boolean isBst;
        int max;
        int min;

        Info(boolean isBst, int max, int min) {
            this.isBst = isBst;
            this.min = min;
            this.max = max;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return getInfo(root).isBst;
    }

    private static Info getInfo(TreeNode node) {
        if (node == null) {
            return null;
        }

        Info left = getInfo(node.left);
        Info right = getInfo(node.right);

        int max = node.val;
        int min = node.val;
        if (left != null) {
            max = Math.max(max, left.max);
            min = Math.min(min, left.min);
        }
        if (right != null) {
            max = Math.max(max, right.max);
            min = Math.min(min, right.min);
        }
        boolean isBest = true;
        if (left != null && !left.isBst) {
            isBest = false;
        }
        if (right != null && !right.isBst) {
            isBest = false;
        }
        boolean leftMaxLgNode = left == null || left.max < node.val;
        boolean rightMinBgNode = right == null || right.min > node.val;

        if (!leftMaxLgNode || !rightMinBgNode) {
            isBest = false;
        }

        return new Info(isBest, max, min);
    }
}
