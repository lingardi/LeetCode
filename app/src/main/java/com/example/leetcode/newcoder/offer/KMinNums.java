package com.example.leetcode.newcoder.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class KMinNums {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input.length == 0 || k <= 0 || k > input.length)
            return res;

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            //因为要满足大根堆需求，所以使用自定义比较器，比较策略为o1大于o2时，o1放o2的前面
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i =0; i < input.length; i++){
            if (i < k){
                queue.add(input[i]);
            }else if (input[i] < queue.peek()){
                queue.poll();
                queue.add(input[i]);
            }
        }
        res.addAll(queue);
        return res;
    }

    public static void main(String[] args) {
        GetLeastNumbers_Solution(new int[]{1,4,5,6,2,3}, 4);
    }

}
