package com.example.leetcode.newcoder.leetcode;

import java.util.Arrays;

/**
 * 有N个小朋友站在一排，每个小朋友都有一个评分
 * 你现在要按以下的规则给孩子们分糖果：
 * 每个小朋友至少要分得一颗糖果
 * 分数高的小朋友要他比旁边得分低的小朋友分得的糖果多
 * 你最少要分发多少颗糖果？
 */
public class Candy {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1); //数组填充，保证每个人最少一个糖
        for (int i = 1; i < candy.length; i++){
            if (ratings[i] > ratings[i-1]){
                candy[i] = candy[i-1] + 1;
            }
        }
        int sum = candy[ratings.length -1];
        for (int j = ratings.length -2 ; j >=0; j-- ){
            if (ratings[j] > ratings[j+1]){
                candy[j] = Math.max(candy[j], candy[j+1] + 1);
            }
            sum += candy[j];
        }
        return sum;
    }
}
