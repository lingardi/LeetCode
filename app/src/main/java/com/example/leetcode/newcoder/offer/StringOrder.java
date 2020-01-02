package com.example.leetcode.newcoder.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class StringOrder {
    private ArrayList<String> res = new ArrayList<>();
    private TreeSet<String> paths = new TreeSet<>();
    private StringBuilder path = new StringBuilder();
    private boolean[] visited;

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.equals("")) {
            return res;
        }
        char[] strs = str.toCharArray();
        Arrays.sort(strs);
        visited = new boolean[strs.length];
        combination(strs, 0);
        res.addAll(paths);
        return res;
    }

    private void combination(char[] strs, int len) {
        if (len == strs.length) {
            paths.add(path.toString());
            return;
        }
        for (int i = 0; i < strs.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.append(strs[i]);
                combination(strs, len + 1);
                //Duang ~ 回溯 - 状态重置
                visited[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    /**
     * TreeSet避免重复字符串出现
     * 思路：
     * 1. 遍历出所有可能出现在第一个位置的字符
     * 2. 固定第一个字符，求后面字符的排列
     * @param str
     * @return
     */
    public static ArrayList<String> Permutation1(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.equals("")) {
            return res;
        }
        TreeSet<String> paths = new TreeSet<>();
        char[] strs = str.toCharArray();
        helper(strs, 0, paths);
        res.addAll(paths);
        return res;
    }

    private static void helper(char[] strs, int begin, TreeSet<String> paths) {
        if (strs.length <= 0 || begin < 0 || begin > strs.length - 1)
            return;
        if (begin == strs.length - 1){
            paths.add(String.valueOf(strs));
        }else {
            for (int i = begin; i < strs.length; i++){
                swap(strs, begin, i);
                helper(strs, begin +1, paths);
                swap(strs, begin, i);
            }
        }

    }

    private static void swap(char[] strs, int begin, int i) {
        char t = strs[begin];
        strs[begin] = strs[i];
        strs[i] = t;
    }

    public static void main(String[] args) {
        Permutation1("abcd");
    }
}
