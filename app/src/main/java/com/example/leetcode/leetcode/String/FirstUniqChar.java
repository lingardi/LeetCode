package com.example.leetcode.leetcode.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        if (s.length() == 0)
            return -1;
        int i = 0;
        for (; i < s.length(); i++){
            int j = 0 ;
            for (; j < s.length(); j++){
                if (s.charAt(i) == s.charAt(j) && i != j)
                    break;
                if (j == s.length() - 1)
                    return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        if (s.length() == 0)
            return -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i < s.length(); i++){
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        for (int i =0; i < s.length(); i++){
            if (map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
