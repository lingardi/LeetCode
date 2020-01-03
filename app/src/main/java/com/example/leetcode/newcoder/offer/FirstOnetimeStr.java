package com.example.leetcode.newcoder.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstOnetimeStr {
    public int FirstNotRepeatingChar(String str) {
        if (str.length() == 0)
            return -1;
        if (str.length() == 1)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            if (map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), -1);
            }else {
                map.put(str.charAt(i), i);
            }
        }

        for (int i = 0; i < str.length(); i++){
            if (map.get(str.charAt(i)) >= 0)
                return map.get(str.charAt(i));
        }

        return -1;
    }
}
