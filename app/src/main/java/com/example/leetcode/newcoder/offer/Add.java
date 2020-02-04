package com.example.leetcode.newcoder.offer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add {
    public int Add(int num1,int num2) {
        if(num1 == 0){
            return num2;
        }
        else if(num2 == 0){
            return num1;
        }
        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        while (carry != 0){
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num2 = carry;
            num1 = sum;
        }
        return sum;
    }
}
