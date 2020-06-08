package com.example.leetcode.newcoder.interview.meituan;

import java.util.Scanner;

public class MaxSubLength {
    public static int maxLength(int[] nums){
        if (nums.length <= 1)
            return nums.length;
        int res = Integer.MIN_VALUE;
        int val = 1;
        for (int i = 0; i < nums.length; i++){
            val = 1;
            int pre = nums[0];
            if (i == 0)
                pre = nums[1];
            for (int j = 0; j < nums.length; j++){
                if (i == j)
                    continue;
                if (nums[j] > pre)
                    val += 1;
                else
                    val = 1;
                pre = nums[j];
                res = Math.max(res, val);
            }

        }
        return res;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
//        int max = 0;
///        int[] datata = new int[]{2,1,3,2,5};
//        for (int i = 0; i < data.length; i++){
//            int[] array = delete(data, i);
//            max = Math.max(max,maxLength(array));
//        }
        int ans = maxLength(nums);
        System.out.println(ans);
    }

    private static int[] delete(int[] data, int index) {
        int[] ans = new int[data.length - 1];
        int a = 0;
        for (int i = 0; i < index; i++){
            ans[a++] = data[i];
        }
        for (int j = index + 1; j < data.length; j++){
            ans[a++] = data[j];
        }
        return ans;
    }
}
