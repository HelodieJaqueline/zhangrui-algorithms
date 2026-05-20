package com.zhangrui.algorithms;

/**
 *
 *
 * @author zhangrui
 * @date 2026/5/19 17:23
 */
public class IsValidBST {

    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean validLeft = isValidBST(root.left);
        if (!validLeft) {
            return false;
        }
        if (pre!=null &&  pre.val >= root.val) {
            return false;
        }
        pre = root;
        return isValidBST(root.right);
    }



}
