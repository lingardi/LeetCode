package com.example.leetcode.leetcode.String.FlagArray;

/**
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 *  
 *
 * 示例1：
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 */
public class CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        int count = 1;
        int[] value = new int[128];
        for (int i = 0; i < s.length(); i++){
            value[s.charAt(i)] ++;
        }
        for (int i = 0; i < value.length; i++){
            if (value[i] % 2 == 1)
                count--;
            if (count < 0)
                return false;
        }
        return true;
    }
}
