package com.example.leetcode.leetcode.String;

/**
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 * 示例2:
 *
 *  输入：s1 = "aa", s2 = "aba"
 *  输出：False
 *
 */
public class IsFlipedString {
    /**
     * s1按照旋转点可分为x = "wat", y = "bottle"，则s2为yx
     * 如果s2由s1旋转而成，则xyxy即s1+s1中必含有s2
     * @param s1
     * @param s2
     * @return
     */
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        String s = s1 + s1;
        return s.contains(s2);
    }
}
