package com.example.leetcode.newcoder.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，
 * 当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class FirstAppearingOnce {
    static int[] chars = new int[128];
    static Queue<Character> queue = new LinkedList<>();
    //Insert one char from stringstream
    public static void Insert(char ch) {
        if (chars[ch] == 0){
            queue.add(ch);
        }
        chars[ch] ++;
    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce() {
        while (!queue.isEmpty()){
            char c = queue.peek().charValue();
            if (chars[c] == 1)
                return c;
            queue.remove();
        }
        return '#';
    }

    public static void main(String[] args) {
        Insert('g');
        Insert('o');
        Insert('o');
        Insert('g');
        Insert('l');
        Insert('e');
        FirstAppearingOnce();
    }

}
