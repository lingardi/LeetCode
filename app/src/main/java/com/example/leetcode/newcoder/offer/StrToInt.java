package com.example.leetcode.newcoder.offer;

/**
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 *
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 *
 * +2147483647
 *     1a33
 *
 * 2147483647
 *     0
 */
public class StrToInt {
    public static int StrToInt(String str) {
        if (str.length() == 0 || str.equals("0"))
            return 0;
        char[] chars = str.toCharArray();
        int ans = 0; //只有一个字符且为"+"或"-"的不合法数值
        int flag = 1;
        boolean firstchar = true;
        boolean overflow = false;
        int start = 0;
        while(chars[start]==' '){
            start ++;//如果str[i]为空格，str[i]顺序后移
        }
        for (int i =start; i < str.length(); i++){
            if (i == start && chars[start] == '-' && firstchar){
                flag = -1;
                continue;
            }

            if (i == start && chars[start] == '+' && firstchar){
                flag = 1;
                continue;
            }

            if (chars[i] < '0' || chars[i] > '9'){
                return 0;
            }
            int c = chars[i] - '0';
            if (i > 8){
                overflow = flag * ans - Integer.MAX_VALUE / 10 + (flag + 1)/2 + c > 8;
            }
            if (overflow){
                return 0;
            }
            if (firstchar){
                ans = flag * c;
            }else {
                ans = ans*10 + flag * c;
            }
            firstchar = false;
        }
        return ans;
    }

    public static void main(String[] args) {
        StrToInt("-123");
    }

}
