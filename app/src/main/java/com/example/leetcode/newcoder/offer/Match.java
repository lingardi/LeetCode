package com.example.leetcode.newcoder.offer;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Match {
    public boolean match(char[] str, char[] pattern){
        return matchStr(str, 0, pattern, 0);
    }

    /**
     *
     * @param str
     * @param i
     * @param pattern
     * @param j
     * @return
     */
    private boolean matchStr(char[] str, int i, char[] pattern, int j) {
        if (str.length ==  i && pattern.length == j)
            return true;
        if (pattern.length == j)
            return false;
        boolean next = (j + 1 < pattern.length && pattern[j + 1] == '*'); // 模式串下一个字符是'*'
        if (next) {
            if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j])) { // 要保证i<str.length，否则越界
                //str为空，pattern为如a*a*a*的情况，*前可出现0次
                return matchStr(str, i, pattern, j + 2) || matchStr(str, i + 1, pattern, j);
            } else {
                return matchStr(str, i, pattern, j + 2);
            }
        } else {
            if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j])) {
                return matchStr(str, i + 1, pattern, j + 1);
            } else {
                return false;
            }
        }
    }
}
