package com.example.leetcode.leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 *
 */
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int index;
        List<Integer> ans = new ArrayList<>();
        //数组的每个值对应到索引，出现的索引对应的值加8，最后只有没出现的索引对应的值小于等于n
        for (int i = 0; i < n; i++){
            //减1的目的：使数值1- n与下标 0- n-1对应
            index = (nums[i] - 1) % n;
            nums[index] += n;
        }
            //若不减1，当nums[i] = 0时，应添加 n, 因为下标0是通过数值n取余得到
        for (int i = 0; i < n; i++){
            if (nums[i] <= n)
                ans.add(i + 1);
        }
        return ans;
     }
}
