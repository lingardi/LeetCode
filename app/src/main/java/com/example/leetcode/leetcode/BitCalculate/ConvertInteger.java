package com.example.leetcode.leetcode.BitCalculate;

/**
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 *
 * 示例1:
 *
 *  输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 *  输出：2
 * 示例2:
 *
 *  输入：A = 1，B = 2
 *  输出：2
 * 提示:
 *
 * A，B范围在[-2147483648, 2147483647]之间
 */
public class ConvertInteger {
    /**
     * 异或为需要更改的个数，n & n-1 为1的个数
     * @param A
     * @param B
     * @return
     */
    public int convertInteger(int A, int B) {
        int ans = 0;
        int num = A ^ B;
        while (num != 0){
            num &= num - 1;
            ans ++;
        }
        return ans;
    }
}
