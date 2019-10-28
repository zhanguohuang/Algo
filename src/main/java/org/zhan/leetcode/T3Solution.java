package org.zhan.leetcode;

import java.util.HashSet;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

 */
public class T3Solution {

    /**
     * not good
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        int current = 0;
        int index = 0;
        HashSet<Integer> hs = new HashSet();
        for (int i=0; i< chars.length;i++) {
            int cn = (int) chars[i];
            if (hs.contains(cn)) {
                current = 0;
                hs.clear();
                index++;
                i = index - 1;
            } else {
                current++;
                hs.add(cn);
            }
            if (current > result) result = current;
        }
        return result;
    }
}
