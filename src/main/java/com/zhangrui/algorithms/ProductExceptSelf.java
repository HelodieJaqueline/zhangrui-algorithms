package com.zhangrui.algorithms;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 *
 * @author zhangrui
 * @date 2026/5/14 10:24
 */
public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        //前缀累积
        result[0] = 1;
        for (int i = 1; i < length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }

        //后缀乘积，初始化成1
        int right = 1;
        for (int i = length - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            //下一轮的后缀乘积
            right = right * nums[i];
        }
        return result;
    }

    public static int[] productExceptSelfV2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        /**
         * 第一遍：
         * 构建左前缀积
         */
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        /**
         * 第二遍：
         * 动态维护右前缀积
         */
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelfV2(new int[]{1, 2, 3, 4})));
    }
}
