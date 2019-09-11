package com.example.leetcode.leetcode.String.DoublePointer;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 */
public class ReverseWords {
    /**
     * 使用builder的reverse和append方法
     * 也可以使用s.split(" ")去掉所有空格
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s.length() == 0)
            return s;
        StringBuilder ans = new StringBuilder();
        //添加空格得" "和' '
        int j = 0;
        for (int i =0; i < s.length(); i++){
            if (' ' == s.charAt(i) ){
                StringBuilder builder = new StringBuilder(s.substring(j, i));
                ans = ans.append(builder.reverse()).append(' ');
                j = i+1;
            }
        }
        return ans.toString() + new StringBuilder(s.substring(j, s.length())).reverse().toString();
    }
}
