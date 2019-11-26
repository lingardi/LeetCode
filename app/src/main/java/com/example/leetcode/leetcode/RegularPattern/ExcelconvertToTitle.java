package com.example.leetcode.leetcode.RegularPattern;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 *
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 *
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 *
 * 输入: 701
 * 输出: "ZY"
 */
public class ExcelconvertToTitle {
    public String convertToTitle(int n) {
        StringBuilder ans = new StringBuilder();
        while (n > 0){
            int c = n % 26;
            //当余数为0时代表该位为Z，同时应该把n相应减小26，避免整除后多出一位
            if (c == 0){
                ans.insert(0, 'Z');
                n -= 26;
            }else {
                ans.insert(0, (char)('A' + c - 1));
            }
            n /= 26;
        }
        return ans.toString();
    }
}
