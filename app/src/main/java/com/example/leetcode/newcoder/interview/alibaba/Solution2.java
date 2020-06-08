package com.example.leetcode.newcoder.interview.alibaba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.XMLFormatter;

public class Solution2 {
    public static void main(String[] args){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] strings = bufferedReader.readLine().split("");
            int n = Integer.valueOf(strings[0]);
            int m = Integer.valueOf(strings[1]);
            int q = Integer.valueOf(strings[2]);

            int[][] r = new int[n][2];
            int[][] c = new int[m][2];
            int[][] rIndex = new int[n][2];
            int[][] cIndex = new int[n][2];

            for (int i = 0; i < n; i++){
                r[i][0] = -1;
                r[i][1] = -1;
            }

            for (int j= 0; j < m; j++){
                c[j][0] = -1;
                c[j][1] = -1;
            }

            for (int i = 0; i < n; i++){

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
