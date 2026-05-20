package com.zhangrui.algorithms;

/**
 *
 *
 * @author zhangrui
 * @date 2026/5/13 11:09
 */
public class ContainerMostOfWater {

    public int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int x = right - left;
            int hl = height[left];
            int hr = height[right];

            int y = Math.max(hl, hr);
        }

        return result;
    }

}
