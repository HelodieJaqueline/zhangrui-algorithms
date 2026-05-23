package com.zhangrui.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 * @author zhangrui
 * @date 2026/5/23 23:01
 */
public class Subsets {
    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return result;
    }

    public void dfs(int[] nums, int startIndex) {

        // 每个 path 都是一个合法子集
        result.add(new ArrayList<>(path));

        for (int i = startIndex; i < nums.length; i++) {

            // 做选择
            path.add(nums[i]);

            // 递归下一层
            dfs(nums, i + 1);

            // 撤销选择（回溯）
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> result = subsets.subsets(new int[]{1, 2, 3});
        System.out.println(result);
    }

}
