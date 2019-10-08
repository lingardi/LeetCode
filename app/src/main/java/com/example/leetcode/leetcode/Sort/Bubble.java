package com.example.leetcode.leetcode.Sort;

public class Bubble {
    public void bubbleSort(int[] nums){
        for (int i = 0; i < nums.length; i++){
            //避免nums[j+1]越界
            for (int j = 0; j < nums.length - i -1; j++){
                if (nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}
