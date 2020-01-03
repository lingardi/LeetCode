package com.example.leetcode.newcoder.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array.length == 0)
            return;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++){
            if (set.contains(array[i])){
                set.remove(array[i]);
            }else {
                set.add(array[i]);
            }
        }
        num1[0] = (int) set.toArray()[0];
        num2[0] = (int) set.toArray()[1];
    }

}
