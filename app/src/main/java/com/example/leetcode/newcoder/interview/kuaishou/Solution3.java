package com.example.leetcode.newcoder.interview.kuaishou;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution3 {
    public static int hasBaozi(String str){
        if (str.length() != 11)
            return 0;
        int index = 3;
        int count = 0;
        int len = str.length();
        int max = 0;
        for (; index < len; index++){
            if (index + 1 < len && str.charAt(index) == str.charAt(index + 1)){
                count ++;
            }else {
                if (count < 3)
                    count = 0;
                else {
                    max = Math.max(count, max);
                }
            }
        }
        return max;
    }

    public static int hasShunzi(String str){
        if (str.length() != 11)
            return 0;
        int index = 3;
        int count = 0;
        int len = str.length();
        int max = 0;
        for (; index < len; index++){
            if (index + 1 < len && str.charAt(index) + 1 == str.charAt(index + 1)){
                count ++;
            }else {
                if (count < 3)
                    count = 0;
                else {
                    max = Math.max(count, max);
                }
            }
        }
        return max;
    }



    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder(scanner.nextLine());
        String[] strs = builder.toString().split(",");
        int count = 0;
        for (String str : strs){
            int baozi = hasBaozi(str);
            int shunzi = hasShunzi(str);
            count += baozi + shunzi;
        }
        if (count == 0)
            System.out.print("null");
    }
}
