package com.example.leetcode.leetcode.RegularPattern;

/**
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 */
public class GetSum {
    /**
     * 异或为无进位加法
     * 与为取进位
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        int jw = a&b;
        a = a ^ b;
        //使用while因为有可能会连续进位
        while (jw != 0){
            b = jw << 1;
            jw = a & b;
            a = a ^ b;
        }
        return a;
    }
}
