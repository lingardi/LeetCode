package com.example.leetcode.leetcode.Array;

import java.util.Stack;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
 * 如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int ans = Integer.MAX_VALUE;
        while (right < nums.length){
            sum += nums[right];
            //等于是对应长度为1的情况
            while (left <= right && sum >= s){
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right ++;
        }
        if (ans == Integer.MAX_VALUE)
            return 0;
        return ans;
    }
}
