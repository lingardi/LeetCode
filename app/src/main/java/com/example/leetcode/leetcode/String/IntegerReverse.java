package com.example.leetcode.leetcode.String;

import java.util.Stack;

/**
  给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

  假设我们的环境只能存储得下 32 位的有符号整数，
  则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class IntegerReverse {
    public int reverse(int x) {
        if (x < -2147483648 || x > 2147483647){
            throw new IllegalArgumentException("超出了");
        }
        String num = Integer.toString(x);
        Stack stack = new Stack();
        StringBuilder builder = new StringBuilder();
        String reverse;
        int result = 0;
        for (int i=0; i < num.length(); i++){
            stack.push(num.charAt(i));
        }
        for (int i=0; i < num.length(); i++){
            builder.append(stack.pop());
        }
        if (num.contains("-")){
            reverse = builder.deleteCharAt(num.length()-1).toString();
        }else {
            reverse = builder.toString();
        }
        try {
            if (num.contains("-")) {
                result = -Integer.parseInt(reverse);
            }else {
                result = Integer.parseInt(reverse);
            }
        } catch (NumberFormatException ex) {
            return 0;
        }
        return result;
    }
}
