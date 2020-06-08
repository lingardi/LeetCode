package com.example.leetcode.newcoder.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * 给定一个字符串s和一组单词dict，在s中添加空格将s变成一个句子，
 * 使得句子中的每一个单词都是dict中的单词
 * 返回所有可能的结果
 * 例如：给定的字符串s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 *
 * 返回的结果为["cats and dog", "cat sand dog"].
 */
public class WordBreak {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        return DFS(s, dict, new HashMap<String, ArrayList<String>>());
    }

    /**
     *
     * 思路：将字符串切割为两部分左边s1和右边s2，如果s1包含在字典中，则递归计算s2切割生成的字符串集合，并将s1和s2返回的结果并和。
     *  *  s2可能无法切割，我们让其返回一个空的ArrayList。
     *  *  s为空串是我们规定返回包含一个“”的ArrayList.
     *  *  仅仅递归会超时，我们用一个map记录字符串对应的结果。
     * @param s
     * @param dict
     * @param map
     * @return
     */
    private ArrayList<String> DFS(String s, Set<String> dict, HashMap<String, ArrayList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        ArrayList<String> res = new ArrayList<>();
        if (s.length() == 0){
            res.add("");
            return res;
        }
        for (String subStr : dict){
            if (s.startsWith(subStr)){
                for (String str : DFS(s.substring(subStr.length()), dict, map)){
                    res.add(subStr + (str.equals("") ? "" : " ") + str);
                }
            }
        }
        map.put(s,res);
        return res;
    }
}
