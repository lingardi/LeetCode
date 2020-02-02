package com.example.leetcode.newcoder.offer;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，
 * 字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class LeftRotateString {
    public static String LeftRotateString(String str, int n) {
        if (str.length() == 0)
            return str;
        int k = n % str.length();
        if (k == 0)
            return str;
        char [] c = str.toCharArray();
        reverse(c, 0, k - 1);
        reverse(c, k, str.length() - 1);
        reverse(c, 0, str.length() - 1);
        StringBuilder res = new StringBuilder();
        for(char t:c) res.append(t);
        return res.toString();
    }

    private static void reverse(char[] c, int start, int end) {
        while (start < end){
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }

    }

    public static void main(String[] args) {
        LeftRotateString("abcXYZdef", 3);
    }
}
