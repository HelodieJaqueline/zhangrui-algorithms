package com.zhangrui.algorithms.zhangruialgorithms;

import java.util.HashMap;

/**
 *
 *
 * @author zhangrui
 * @date 2026/5/11 16:35
 */
public class TwoSum {



    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{map.get(result), nums[i]};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
