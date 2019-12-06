package com.example.leetcode.leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 *
 * 示例 1:
 *
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 * 示例 2:
 *
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 */
public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0)
            return ans;
        int low = nums[0];
        int high = nums[0];
        StringBuilder builder = new StringBuilder();
        if (nums.length == 1){
            builder.append(nums[0]);
            ans.add(builder.toString());
            return ans;
        }
        for (int i =1; i < nums.length; i++){
            if (nums[i] > high + 1){
                if (high > low){
                    builder.append(low).append("->").append(high);
                }else {
                    builder.append(low);
                }
                ans.add(builder.toString());
                builder.setLength(0);
                low = nums[i];
            }
            high = nums[i];
            if (i == nums.length - 1){
                if (nums[i] > low){
                    builder.append(low).append("->").append(high);
                }else {
                    builder.append(low);
                }
                ans.add(builder.toString());
            }
        }
        return ans;
    }

    public List<String> summaryRanges2(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        int start = nums[0];
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == temp + 1) {
                temp = nums[i];
            } else {
                if (temp == start) {
                    ans.add(String.valueOf(temp));
                } else {
                    ans.add(String.valueOf(start) + "->" + String.valueOf(temp));
                }
                start = nums[i];
                temp = nums[i];
            }
        }
        if (temp == start) {
            ans.add(String.valueOf(temp));
        } else {
            ans.add(String.valueOf(start) + "->" + String.valueOf(temp));
        }
        return ans;
    }


    public static void main(String[] args){
        summaryRanges(new int[]{0,1,2,4,5,7});
    }
}
