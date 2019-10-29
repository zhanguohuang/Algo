package org.zhan.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public int lengthOfLongestSubstringSlideWindow1(String s) {
        int n = s.length();
        Set<Character> set =  new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while(i < n && j < n) {
            if (set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstringSlideWindowBest(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
