package com.example.leetcode.newcoder.offer;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array.length < 2)
            return res;
        int left = 0;
        int right = array.length - 1;
        int min = Integer.MAX_VALUE;
        while (left < right){
            int s = array[left] + array[right];
            if (s < sum){
                left++;
            }else if (s > sum){
                right--;
            }else {
                if (array[left] * array[right] < min){
                    res.clear();
                    res.add(array[left]);
                    res.add(array[right]);
                    min = array[left] * array[right];
                }
                left++;
                right--;
            }
        }
        return res;
    }
}
