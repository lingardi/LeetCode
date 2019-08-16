package com.example.leetcode.leetcode.String;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */

public class Palindrome {
    public boolean isPalindrome(int x) {
        String string = Integer.toString(x);
        StringBuilder builder = new StringBuilder(string);
        if (string.equals(builder.reverse().toString())){
            return true;
        }else {
            return false;
        }
    }
}
