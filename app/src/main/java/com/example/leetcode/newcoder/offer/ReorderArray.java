package com.example.leetcode.newcoder.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReorderArray {
    public void reOrderArray(int [] array) {
        if (array.length < 2)
            return;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 == 1){
                list1.add(array[i]);
            }else {
                list2.add(array[i]);
            }
        }
        for (int i = 0; i < array.length; i++){
            if (i < list1.size()){
                array[i] = list1.get(i);
            }else {
                array[i] = list2.get(i -list1.size());
            }
        }
    }

    public void reOrderArray2(int [] array) {
        if (array.length < 2)
            return;
        int start = 0;
        int end = array.length - 1;
        while (start < end){
            while (start < end && array[start] % 2 == 1){
                start++;
            }
            while (start < end && array[end] % 2 == 0){
                end--;
            }

            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
    }
}
