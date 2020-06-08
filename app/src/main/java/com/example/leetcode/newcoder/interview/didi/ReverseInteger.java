package com.example.leetcode.newcoder.interview.didi;

public class ReverseInteger {
    public static int reverse(int n){
        if (Math.abs(n) < 10)
            return n;
        int ans = 0;
        while (n != 0){
            int num = n%10;
            n /= 10;
            if (ans > Integer.MAX_VALUE/10 || ans == Integer.MAX_VALUE/10 && num > 7)
                throw new RuntimeException("overflow");
            if (ans < Integer.MIN_VALUE/10 || ans == Integer.MIN_VALUE/10 && num > 8)
                throw new RuntimeException("overflow");
            ans = ans * 10 + num;
        }
        return ans;
    }

    public static void main(String[] args){
        reverse(1234567893);
    }

}
