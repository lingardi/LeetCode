package com.example.leetcode.leetcode.Array.Hash;

import java.util.HashMap;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int i=0;
        for (; i < nums.length; i++){
            if (! hashMap.keySet().contains(nums[i]))
                hashMap.put(nums[i], 0);
            int count = hashMap.get(nums[i]) + 1;
            hashMap.put(nums[i], count);
            if (count > nums.length/2)
                break;
        }
        return nums[i];
    }

    public int majorityElement2(int[] nums) {
        int sum = 0;
        int candidate = 0;
        for (int i =0 ;i < nums.length; i++){
            if (sum == 0)
                candidate = nums[i];
            sum += nums[i] == candidate ? 1 : -1;
        }
        return candidate;
    }
}
