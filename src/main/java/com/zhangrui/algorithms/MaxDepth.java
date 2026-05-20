package com.zhangrui.algorithms;

/**
 *
 *
 * @author zhangrui
 * @date 2026/5/19 15:08
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftMax = maxDepth(left);
        int rightMax = maxDepth(right);
        return Math.max(leftMax, rightMax) + 1;
    }

}
