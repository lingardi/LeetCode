package com.example.leetcode.leetcode.Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 *
 * 输入: [3, 2, 1]
 *
 * 输出: 1
 *
 * 解释: 第三大的数是 1.
 * 示例 2:
 *
 * 输入: [1, 2]
 *
 * 输出: 2
 *
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 *
 * 输入: [2, 2, 3, 1]
 *
 * 输出: 1
 *
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 */
public class ThirdMax {
    public int thirdMax(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        //hashmap记录三个变量出现的次数，判断是否存在第三大
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int cur = nums[i];
            if (map.containsKey(cur)){
                map.put(cur, map.get(cur) + 1);
            }else {
                map.put(cur, 1);
                if (cur > first){
                    third = second;
                    second = first;
                    first = cur;
                }else if (cur > second){
                    third = second;
                    second = cur;
                } else if (cur > third){
                    third = cur;
                }
            }
        }
        if (map.get((int)third) != null && map.get((int)second) != null && third < second){
            return (int) third;
        }else {
            return (int) first;
        }
    }

    public int thirdMax2(int[] nums) {
        //避免数组中不存在第三大数值，且数组中含有int最小值，在没有hashmap的情况下输出的third错误
        long MIN = Long.MIN_VALUE;
        if (nums == null || nums.length == 0) throw new RuntimeException("nums is null or length of 0");
        int n = nums.length;

        int one = nums[0];
        long two = MIN;
        long three = MIN;

        for (int i = 1; i <  n; i++) {
            int now = nums[i];
            if (now == one || now == two || now == three) continue;    // 如果存在过就跳过不看
            if (now > one) {
                three = two;
                two = one;
                one = now;
            } else if (now > two) {
                three = two;
                two = now;
            } else if (now > three) {
                three = now;
            }
        }

        if (three == MIN) return one;  // 没有第三大的元素，就返回最大值
        return (int)three;

    }
}
