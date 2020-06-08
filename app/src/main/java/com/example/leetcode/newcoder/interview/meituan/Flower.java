package com.example.leetcode.newcoder.interview.meituan;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Flower{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int length = in.nextInt();
        read(in, length, priorityQueue);
        long firstSum = sumValue(priorityQueue);
        read(in, length, priorityQueue);
        long secondSum = sumValue(priorityQueue);
        if (firstSum > secondSum)
            System.out.println(firstSum);
        else
            System.out.println(secondSum);
    }

    private static long sumValue(PriorityQueue<Integer> priorityQueue) {
        if (priorityQueue.size() == 0)
            return 0;
        int res = 0;
        while (!priorityQueue.isEmpty()){
            res += priorityQueue.poll();
        }
        return res;
    }

    private static void read(Scanner in, int length, PriorityQueue<Integer> priorityQueue) {
        int size = 0;
        priorityQueue.clear();
        while (in.hasNextInt() && length >= 0){
            if (size < 3){
                priorityQueue.add(in.nextInt());
                size ++;
            }else {
                int temp = in.nextInt();
                if (temp > priorityQueue.peek()){
                    priorityQueue.poll();
                    priorityQueue.add(temp);
                }
            }
        }
    }
}
