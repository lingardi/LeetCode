package com.example.leetcode.leetcode.Array.DoublePointer;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int end = digits.length -1;
        if (!(digits[end] == 9)){
            digits[end] = digits[end] + 1;
            return digits;
        }
        while (end >= 0 && digits[end] == 9){
            digits[end] = 0;
            end --;
        }
        if (end == -1){
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }else {
            digits[end] = digits[end] + 1;
        }
        return digits;
    }
}
