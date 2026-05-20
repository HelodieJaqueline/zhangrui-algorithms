package com.zhangrui.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 *
 * @author zhangrui
 * @date 2026/5/12 14:50
 */
public class FindAnagrams {


/*    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            window.put(r, window.getOrDefault(r, 0) + 1);
            if (right - left + 1 == p.length()) {
                if (pMap.equals(window)) {
                    result.add(left);
                }
                char l = s.charAt(left);
                int count = window.get(l);
                if (count == 1) {
                    window.remove(l);
                } else {
                    window.put(l, count - 1);
                }
                left++;
            }
            right++;
        }
        return result;
    }*/

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        HashMap<Character, Integer> pMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char pc = p.charAt(i);
            pMap.put(pc, pMap.getOrDefault(pc, 0) + 1);
        }
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            window.put(r, window.getOrDefault(r, 0) + 1);
            if (right - left + 1 == p.length()) {
                if (pMap.equals(window)) {
                    result.add(left);
                }
                char l = s.charAt(left);
                int count = window.get(l);
                if (count == 1) {
                    window.remove(l);
                } else {
                    window.put(l, window.get(l) - 1);
                }
                left++;
            }
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        System.out.println(findAnagrams.findAnagrams("ababababab", "aab"));
        System.out.println(findAnagrams.findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams.findAnagrams("abab", "ab"));
    }

}
