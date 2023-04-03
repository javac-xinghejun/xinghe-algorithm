package org.xinghe.algorithm.leetcode;

import org.xinghe.algorithm.datastructure.TreeNode;

/**
 * 描述
 *
 * @author 星河君❀❀ 2022/5/26 20:46
 * @see [相关类/方法]
 * @since [版本号]
 */
public class Test105 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || inorder.length != preorder.length) {
            return null;
        }
        return f(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode f(int[] pre, int l1, int r1, int[] in, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[l1]);
        if (pre.length == 1) {
            return head;
        }

        int find = l2;//头结点

        // 在中序数组中找到这个值
        while (in[find] != pre[l1]) {
            find++;
        }

        head.left = f(pre, l1 + 1, l1 + find - l2, in, l2, find - 1);
        head.right = f(pre, l1 + find - l2 + 1, r1, in, find + 1, r2);
        return head;
    }
}
