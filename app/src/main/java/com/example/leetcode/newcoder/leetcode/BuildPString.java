package com.example.leetcode.newcoder.leetcode;

/**
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？输出需要删除的字符个数。
 *
 * 输入：
 * 输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000
 *
 * 输出：
 * 对于每组数据，输出一个整数，代表最少需要删除的字符个数。
 *
 */
public class BuildPString {
    /**
     * 1. 得到翻转字符串
     * 2. 求原串和翻转串的最大公共子序列s
     * 3. 返回值 = 串长 -  s
     * @param str
     * @return
     */
    public static int deleteChar(String str){
        if (str.length() == 0)
            return 0;
        String reversedStr = new StringBuilder(str).reverse().toString();
        //使用动态规划求最大公共子序列
        int len = str.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length ; j++){
                dp[i][j] = str.charAt(i - 1) == reversedStr.charAt(j-1) ? dp[i-1][j-1] +1 :
                        Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return len - dp[len][len];
    }

    public static void main(String[] args){
        System.out.println(deleteChar("abdca"));
    }
}
