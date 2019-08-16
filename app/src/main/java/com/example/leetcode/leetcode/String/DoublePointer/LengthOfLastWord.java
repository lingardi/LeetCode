package com.example.leetcode.leetcode.String.DoublePointer;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if ("".equals(s)){
            return 0;
        }
        int end = s.length() - 1;
        while (end > 0 && s.charAt(end) == ' '){
            end --;
        }
        int start = end;
        while (start >= 0 && !(s.charAt(start) == ' ')){
            start --;
        }
        return end - start;
    }
}
