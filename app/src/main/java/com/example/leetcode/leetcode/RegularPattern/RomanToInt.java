package com.example.leetcode.leetcode.RegularPattern;

import java.util.HashMap;

/**
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 */
public class RomanToInt {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        int result = 0;
        int pre = 1000;
        for (int i=0; i < s.length(); i++){
            result = result + hashMap.get(s.toCharArray()[i]);
            if (hashMap.get(s.toCharArray()[i]) > pre) {
                result = result - (2 * pre);
            }
            pre = hashMap.get(s.toCharArray()[i]);
        }
        return result;
    }
}
