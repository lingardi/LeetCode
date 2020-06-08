package com.example.leetcode.leetcode.String.FlagArray;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 */
public class CheckPermutation {
    /**
     * 标记数组，ASCII字符有127位？？
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0)
            return true;
        if (s1.length() != s2.length())
            return false;
        int[] value = new int[128];
        for (int i = 0; i < s1.length(); i++){
            value[s1.charAt(i)]++;
            value[s2.charAt(i)]--;
        }
        for (int i = 0; i < value.length; i++){
            if (value[i] != 0)
                return false;
        }
        return true;
    }
}
