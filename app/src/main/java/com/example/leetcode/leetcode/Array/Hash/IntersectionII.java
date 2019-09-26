package com.example.leetcode.leetcode.Array.Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 */
public class IntersectionII {
    /**
     * 先统计第一个数组，出现一次hash值加1
     * 统计第二个数组，出现一次hash值减1，hash值 > 0代表可加入结果
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0)
            return nums1;
        if (nums2.length == 0)
            return nums2;
        Map<Integer, Integer> map = new HashMap<>();
        int[] arrays = new int[Math.min(nums1.length , nums2.length)];
        int[] ans;
        for (Integer i : nums1){
            if (map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }else {
                map.put(i, 1);
            }
        }
        int index = 0;
        for (Integer i : nums2){
            if (map.containsKey(i)){
                int val = map.get(i);
                if (val >= 1){
                    map.put(i, val - 1);
                    arrays[index++] = i;
                }
            }
        }
        ans = Arrays.copyOf(arrays, index);
        return ans;
    }
}
