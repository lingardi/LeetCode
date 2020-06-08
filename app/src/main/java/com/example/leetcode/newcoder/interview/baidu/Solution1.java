package com.example.leetcode.newcoder.interview.baidu;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution1 {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int[] a = new int[n];
//        int[] b = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> valueMap = new HashMap<>();

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int[] a = new int[]{10,20,30,40,50};
        int[] b = new int[]{4,5,6,7,8};
        int n = 5,m = 5;

        for (int i = 0; i < n; i++){
//            a[i] = scanner.nextInt();
            queue.offer(a[i]);
            valueMap.put(a[i], a[i]);
        }

        for (int i = 0; i < n; i++){
//            b[i] = scanner.nextInt();
            map.put(a[i], b[i]);
        }


        if (n == 1){
            System.out.println(a[0]);
        }else {
            System.out.println(maxSum(a, b, m, queue, map, valueMap));
        }
    }

    private static long maxSum(int[] a, int[] b, int m, PriorityQueue<Integer> queue, Map<Integer, Integer> map, Map<Integer, Integer> valueMap) {
        long ans = 0;
        while (m > 0 && !queue.isEmpty()){
            int temp = queue.poll();
            ans += valueMap.get(temp);
            valueMap.remove(temp);
            map.remove(temp);
            for (Integer num : queue){
                valueMap.put(num, valueMap.get(num) - map.get(num));
            }
            m--;
        }
        return ans;
    }
}
