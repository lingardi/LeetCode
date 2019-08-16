package com.example.leetcode.leetcode.String;

import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 */
public class AddBinary {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public String addBinary(String a, String b) {
        int i=a.length() -1;
        int j=b.length() -1;

        int carry = 0;// 进位

        StringBuilder sb = new StringBuilder();

        while(i > -1 || j > -1) {

            int abit = i > -1 ? a.charAt(i) - '0' : 0;
            int bbit = j > -1 ? b.charAt(j) - '0' : 0;

            int sum = abit + bbit + carry;// 00, 01, 10, 11

            sb.insert(0, sum & 1);
            carry = (sum >>> 1) & 1;

            i--;
            j--;
        }
        if(carry == 1)
            sb.insert(0, 1);
        return sb.toString();

    }
}
