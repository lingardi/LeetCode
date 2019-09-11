package com.example.leetcode.leetcode.String;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        int len = s.length();
        s = s.toLowerCase(); //统一转为小写
        int i = 0, j = len - 1;
        while (i < j) {
            //跳过非法字符
            while (!isAlphanumeric(s.charAt(i))) {
                i++;
                //匹配 "   " 这样的空白字符串防止越界
                if (i == len) {
                    return true;
                }
            }
            while (!isAlphanumeric(s.charAt(j))) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        if ('a' <= c && c <= 'z' || 'A' <= c && c <= 'Z' || '0' <= c && c <= '9') {
            return true;
        }
        return false;
    }
}
