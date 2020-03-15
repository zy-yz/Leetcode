package com.zy.leet.zero;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaoyu
 */

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
public class LengthOfLongestSubstring {
    //定义一个map数据结构存储,其中key为字符，value为字符位置加一，加一表示字符位置后一个不重复
    //定义不重复子串的位置为start,结束位置为end
    //随着end不断向后遍历,会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，
    // 获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }


    //https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/
    //链接动图，不仅骚而且强.
    public static void main(String[] args) {
        String s = "abcabcdabfhua";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
