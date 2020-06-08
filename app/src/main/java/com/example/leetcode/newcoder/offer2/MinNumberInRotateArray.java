package com.example.leetcode.newcoder.offer2;

public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0)
            return 0;
        int left = 0;
        int right = array.length - 1;
        int ans = Integer.MAX_VALUE;
        while (left <= right){
            int mid = (left + right) >>> 1;
            if (array[mid] < ans){
                ans = array[mid];
            }

            if (array[left] < array[mid]){
                if (array[left] < ans && array[left] < array[right]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if (array[right] < ans && array[right] < array[left]){
                    left = mid + 1;
                }else {
                    right = mid -1;
                }
            }
        }
        return ans;
    }
}
