package com.example.leetcode.leetcode.String.DoublePointer;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 思路：双循环
 */

public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        String result = strs[0];
        for (int i=0; i < strs.length; i++){
            int j =0;
            for (; j<result.length() && j < strs[i].length(); j++ ){
                if (result.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            result = strs[0].substring(0,j);
            if (result.equals("")){
                return "";
            }
        }
        return result;
    }
}
