package com.zhangrui.algorithms.zhangruialgorithms;

import java.util.HashSet;

/**
 *
 *
 * @author zhangrui
 * @date 2026/5/11 17:12
 */
public class LengthOfLongestSubstring {


    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> window = new HashSet<>();
        int left = 0, right = 0, max = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            while (window.contains(r)) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(r);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

}
