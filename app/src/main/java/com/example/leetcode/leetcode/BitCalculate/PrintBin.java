package com.example.leetcode.leetcode.BitCalculate;

/**
 * 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。
 * 如果该数字不在0和1之间，或者无法精确地用32位以内的二进制表示，则打印“ERROR”。
 *
 * 示例1:
 *
 *  输入：0.625
 *  输出："0.101"
 * 示例2:
 *
 *  输入：0.1
 *  输出："ERROR"
 *  提示：0.1无法被二进制准确表示
 */
public class PrintBin {
    public String printBin(double num) {
        if (num < 0 || num > 1d){
            return "ERROR";
        }
        char[] bits = new char[32];
        bits[0] = '0';
        bits[1] = '.';
        int cur = 2;
        int division = 2;

        while (num != 0 && cur < 32){
            if (num * division >= 1){
                bits[cur] = '1';
                num -= 1d / division;
            }else {
                bits[cur] = '0';
            }
            division *= 2;
            cur++;
        }
        if (num != 0)
            return "ERROR";
        return String.valueOf(bits, 0, cur);
    }
}
