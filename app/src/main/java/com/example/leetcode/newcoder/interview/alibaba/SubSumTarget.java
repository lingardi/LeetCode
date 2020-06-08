package com.example.leetcode.newcoder.interview.alibaba;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.HashMap;
import java.util.Map;

/**
 * 给出一个正整数数组和一个数，返回一个数组中连续元素的和等于所给数的子数组
 */
public class SubSumTarget {

    /**
     * 前缀和，结果数组的右边界的前缀和 - 左边界的前缀和 = k
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                if (sum[end] - sum[start] == k)
                    count++;
            }
        }
        return count;
    }

    /**
     * 前缀和+hashmap
     * 如果s[right] - s[left - 1] = k 则有 s[left - 1] = s[right] - k,
     * 则原题变成在数列中寻找s[right] - k 出现次数
     * @param nums
     * @param k
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int subarraySum2(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i]; //前缀和
            if (map.containsKey(sum - k)) ans += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
