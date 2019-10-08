package com.example.leetcode.leetcode.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，
 * 并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * ？？？？
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2 || k < 0 || k > nums.length)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i =0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                ans = Math.max(i - map.get(nums[i]), ans);
                if (ans > k)
                    return false;
            }else {
                map.put(nums[i], i);
            }
        }
        return ans == k;
    }
}
