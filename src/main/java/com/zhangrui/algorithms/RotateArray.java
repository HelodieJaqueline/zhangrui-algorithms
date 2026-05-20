package com.zhangrui.algorithms;

import java.util.Arrays;

/**
 *
 *
 * @author zhangrui
 * @date 2026/5/18 10:25
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        //全量反转
        reverse(nums, 0, n - 1);

        //前k个反转
        reverse(nums, 0, k-1);

        //后n-k个反转
        reverse(nums, k, n - 1);

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(nums));
        new RotateArray().rotate(nums, 4);
        System.out.println(Arrays.toString(nums));
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}
