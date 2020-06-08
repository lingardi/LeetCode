package com.example.leetcode.leetcode.String;

/**
 *
 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。

 示例 1：

 输入: s = "leetcode"
 输出: false
 示例 2：

 输入: s = "abc"
 输出: true
 限制：

 0 <= len(s) <= 100
 如果你不使用额外的数据结构，会很加分
 */
public class IsUnique {
    /**
     * 位运算
     * 字符范围为a - z，使用二进制表示字符，int型变量循环左移一位，每个字符与a的差为左移位数
     * 声明一个mask变量，当mask && 二进制字符 = 0时表示未重复，否则重复
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {
        if (astr.length() < 2)
            return true;
        int mask = 0;
        for (char i : astr.toCharArray()){
            int bit = i - 'a';
            if ((mask & (1 << bit)) != 0){
                return false;
            }else {
                mask |= 1 << bit;
            }
        }
        return true;
    }
}
