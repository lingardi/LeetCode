package com.example.leetcode.leetcode.Array;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 思路： 某个数之前的和小于0则以该数为起点计和
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int i=0; i < nums.length; i++){
            if (sum + nums[i] < nums[i]){
                sum = nums[i];
            }else {
                sum = sum + nums[i];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
