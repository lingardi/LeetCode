package com.example.leetcode.leetcode.RegularPattern;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例: 
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 1 + 81 = 82
 * 64 + 4 = 68
 * 36 + 64 = 100
 * 1 + 0 + 0 = 1
 *
 */
public class IsHappy {
    public boolean isHappy(int n) {
        if (n == 1)
            return true;
        Set<Integer> set = new HashSet<>();
        int m = 0;
        while (true){
            while (n != 0){
                m += Math.pow(n % 10, 2);
                n = n/10;
            }
            if (m == 1)
                return true;
            //如果平方和已经存在得话，说明陷入了循环
            if (set.contains(m))
                return false;
            else
                set.add(m);
                n = m;
                m = 0;
        }
    }
}
