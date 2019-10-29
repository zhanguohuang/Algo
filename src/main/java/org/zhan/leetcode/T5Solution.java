package org.zhan.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

 示例 1：

 输入: "babad"
 输出: "bab"
 注意: "aba" 也是一个有效答案。
 示例 2：

 输入: "cbbd"
 输出: "bb"

 */
public class T5Solution {

    public static String longestPalindrome(String s) {
        String result = "";
        if (s.length() >= 1) {
           result = String.valueOf(s.charAt(0));
        }
        if (s.length() == 0) {
            return result;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0;i< s.length(); i++) {
            char c = s.charAt(i);
            if (map.keySet().contains(c)) {
                if (i + 1 - map.get(c) > result.length()) {
                    result = s.substring(map.get(c), i+1);
                }
            }
            map.put(c, i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
    }
}
