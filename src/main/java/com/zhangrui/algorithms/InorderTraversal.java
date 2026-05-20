package com.zhangrui.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 * @author zhangrui
 * @date 2026/5/19 16:23
 */
public class InorderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (null == root) {
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }

}
