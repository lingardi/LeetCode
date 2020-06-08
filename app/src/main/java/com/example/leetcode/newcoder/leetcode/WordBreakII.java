package com.example.leetcode.newcoder.leetcode;

import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.Set;

public class WordBreakII {
    /**
     * 动态规划，判断str的最后一个字符能否被一个单词包含
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (dict.size() == 0)
            return false;
        boolean[] array = new boolean[s.length() + 1];
        array[0] = true;

        //i代表str的单词结尾点,j代表
        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j < i; j++){
                if (array[j] && dict.contains(s.substring(j, i))){
                    array[i] = true;
                    break;
                }
            }
        }
        return array[s.length()];
    }

}
