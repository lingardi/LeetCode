package com.example.leetcode.leetcode.String.DoublePointer;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 */
public class RealizestrStr {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")){
            return 0;
        }
        if (haystack.equals("") || needle.length() > haystack.length()){
            return -1;
        }
        int length1 = haystack.length();
        int length2 = needle.length();
        int i = 0;
        for (; i < length1 - length2 +1; i++){ //至少做长度差+1次循环（考虑needle出现在haystack末尾的情况）
            int j = 0;
            for (; j < length2; j++){ //需每个字母对应上
                if (haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
            }
            if (j == length2){
                return i;
            }
        }
        return -1;
    }
}
