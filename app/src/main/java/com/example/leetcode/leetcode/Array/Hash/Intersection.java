package com.example.leetcode.leetcode.Array.Hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Intersection {
    /**
     * 先统计第一个数组，元素唯一，hash值均为1
     * 第二个数组出现相同值则hash值加1
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0)
            return nums1;
        if (nums2.length == 0)
            return nums2;
        int[] array = new int[Math.min(nums1.length, nums2.length)];
        int[] ans;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer i : nums1){
            if (!hashMap.containsKey(i))
                hashMap.put(i, 1);
        }
        int index = 0;
        for (int i =0; i < nums2.length; i++){
            if (hashMap.containsKey(nums2[i])){
                hashMap.put(nums2[i], hashMap.get(nums2[i]) + 1);
                if (hashMap.get(nums2[i]) == 2)
                    array[index++] = nums2[i];
            }
        }
        ans = Arrays.copyOf(array, index);
        return ans;
    }
}
