package com.zhangrui.algorithms;

/**
 *
 *
 * @author zhangrui
 * @date 2026/5/20 15:55
 */
public class LowestCommonAncestor {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        //左子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        //右子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }


        return left == null ? right : left;
    }

}
