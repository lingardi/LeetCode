package com.example.leetcode.leetcode.BitCalculate;

/**
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 *
 * 示例 1：
 *
 * 输入: num = 1775(110111011112)
 * 输出: 8
 * 示例 2：
 *
 * 输入: num = 7(01112)
 * 输出: 4
 *
 */
public class ReverseBitsII {
    public int reverseBits(int num) {
        if (num == 0)
            return 1;
        int pre = 0; // 0左边的
        int after = 0; //0右边的
        int index = 0;
        long ans = Long.MIN_VALUE; // 0左边 + 0右边 + 1
        while (index++ < 32){
            if ((num & 1) == 0){
                ans = Math.max(ans, after + pre + 1);
                after = pre;
                pre = 0;
            }else {
                pre++;
            }
            num >>= 1;
        }
        ans = Math.max(ans, after + pre + 1);
        return (int) ans;
    }
}
