package com.example.leetcode.leetcode.Stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 */

public class ValidBrackets {
    public boolean isValid(String s) {
        if (s.equals("")){
            return true;
        }
        if (s.length()%2 != 0){
            return false;
        }
        HashMap<Character, Character> hashMap = new HashMap();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i= 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (hashMap.containsKey(c)){
                if (!stack.isEmpty() && stack.peek().equals(hashMap.get(c))){
                    stack.pop();
                }else {
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
