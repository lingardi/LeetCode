package com.example.leetcode.newcoder.leetcode;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0; //总油量
        int run = 0; //剩余油量
        int start = 0; //起始位置
        for (int i =0; i < gas.length; i++){
            sum += gas[i] - cost[i];
            run += gas[i] - cost[i];

            //代表局部站之间无法通行，原start位置无法作为起始站
            if (run < 0){
                start = i+1;
                run = 0;
            }
        }
        //判断全部油量是否够用
        return sum >= 0 ? start : -1;
    }
}
