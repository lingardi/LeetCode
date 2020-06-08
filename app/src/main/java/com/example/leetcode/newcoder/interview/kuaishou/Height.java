package com.example.leetcode.newcoder.interview.kuaishou;

import java.util.Scanner;
import java.util.Stack;

public class Height {
    public static int[] DistanceToHigher(int[] height) {
        int len = height.length;
        if (len == 0)
            return new int[]{};
        int[] ans = new int[len];
        if (len == 1)
            return ans;
        int count = 0;
        int j = 0;
        for (int i = 0; i < len; i++){
            count = 0;
            for (j = i - 1; j >= 0; j--){
                count++;
                if (height[j] > height[i])
                    break;
            }
            if (j < 0)
                ans[i] = 0;
            else
                ans[i] = count;
        }
        return ans;
    }

    public static void main(String[] args){
        int[] data = new int[]{175,179,174,163,176,177};
        int[] nums = DistanceToHigher(data);
        for (Integer i : nums)
            System.out.print(i);
    }

}
