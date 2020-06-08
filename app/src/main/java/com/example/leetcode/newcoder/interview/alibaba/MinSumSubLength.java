package com.example.leetcode.newcoder.interview.alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinSumSubLength {
    public static int[] minSumSubLength(int[] nums, int N, int L){
        int[] res = new int[2];
        res[1] = -1;
        if (nums.length == 0 || nums.length < L || N < 0)
            return res;
        int low = 0;
        int high = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        res[0] = ans;
        while (high < nums.length){
            sum += nums[high];
            while (low <= high && sum >= N){
                if (high - low + 1 < L)
                    break;
                if (sum == N && high - low + 1 < ans){
                    ans = high - low +1;
                    res[0] = ans;
                    res[1] = low;
                }
                sum -= nums[low];
                low++;
            }
            high++;
        }
        if (ans == Integer.MAX_VALUE){
            res[1] = -1;
        }
        return res;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int L = scanner.nextInt();
        int len = N / 2 + 1;
        int[] nums = new int[len];
        for (int i= 0; i < len; i++){
            nums[i] = i + 1;
        }
        int[] ans = minSumSubLength(nums, N, L);
        if (ans[1] == -1 || ans[0] > 100){
            System.out.println("No");
        } else {
            for (int i = ans[1]; i < ans[1] + ans[0]; i++){
                System.out.print(nums[i] + " ");
            }
        }
//        for (int i = 0; i < ans.size(); i++){
//            System.out.println(ans.get(i));
//        }
    }
}
