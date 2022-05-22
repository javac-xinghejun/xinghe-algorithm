package org.xinghe.algorithm.leetcode;

import org.xinghe.algorithm.datastructure.TreeNode;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/22 16:02
 * @see [相关类/方法]
 * @since [版本号]
 */
public class MirrorTreeTest {
    public static boolean isMirrorTree(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode h1, TreeNode h2) {
        if (h1 == null ^ h2 == null) {
            return false;
        }
        if (h1 == null && h2 == null) {
            return true;
        }
        return h1.val == h2.val && isMirror(h1.right, h2.left) && isMirror(h1.left, h2.right);
    }
}
