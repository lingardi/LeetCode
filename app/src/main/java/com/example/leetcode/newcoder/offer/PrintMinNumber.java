package com.example.leetcode.newcoder.offer;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        StringBuilder builder = new StringBuilder();
        if (numbers.length == 0)
            return builder.toString();
        for (int i = 0; i < numbers.length; i++){
            for (int j = i + 1; j < numbers.length; j++){
                //比较哪个在前面更小，并交换
                int s1 = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int s2 = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if (s1 > s2) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        for (int i = 0; i < numbers.length; i++){
            builder.append(numbers[i]);
        }
        return builder.toString();
    }
}
