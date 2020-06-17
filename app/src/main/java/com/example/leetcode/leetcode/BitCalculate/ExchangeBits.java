package com.example.leetcode.leetcode.BitCalculate;

/**
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 *
 * 示例1:
 *
 *  输入：num = 2（或者0b10）
 *  输出 1 (或者 0b01)
 * 示例2:
 *
 *  输入：num = 3
 *  输出：3
 * 提示:
 *
 * num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
 *
 */
public class ExchangeBits {
    public int exchangeBits(int num) {
        int odd = 0x55555555 & num; //奇数位
        int even = 0xAAAAAAAA & num; //偶数位
        return (odd << 1) | (even >> 1);
    }
}
