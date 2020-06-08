package com.example.leetcode.newcoder.interview.kuaishou;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution2 {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static ArrayList<Integer> getIndex(int[] nums){
        int len = nums.length;
        if (len < 2)
            return new ArrayList<Integer>();
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        queue.add(nums[0]);
        int second = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++){
            if (nums[i] > queue.peek()){
                second = queue.peek();
            }
            if (nums[i] < queue.peek() && nums[i] >= second){
                ans.add(i);
            }
            queue.add(nums[i]);
        }
        return ans;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder builder = new StringBuilder(scanner.nextLine());
//        String[] strings = builder.toString().split(" ");
//        int[] nums = new int[strings.length];
//        for (int i = 0; i < strings.length; i++){
//            nums[i] = Integer.valueOf(strings[i]);
//        }
//
//        ArrayList<Integer> res = getIndex(nums);
//        if (res.size() == 0){
//            System.out.print(-1);
//        }else {
//            for (Integer i : res){
//                System.out.print(i + " ");
//            }
//        }

        int[] data = new int[]{1, 22, 22, 33,22, 12,45,44,5};
        ArrayList<Integer> nums = getIndex(data);
        for (Integer i : nums) {
            System.out.print(i + " ");
        }
    }
}
