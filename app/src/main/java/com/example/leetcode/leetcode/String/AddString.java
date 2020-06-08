package com.example.leetcode.leetcode.String;

public class AddString {
    public String addString(String str1, String str2){
        StringBuilder builder = new StringBuilder();
        if (str1.length() == 0 && str2.length() == 0)
            return builder.toString();
        if (str1.length() == 0)
            return str2;
        if (str2.length() == 0)
            return str1;
        int l1 = str1.length() -1;
        int l2 = str2.length() -1;
        int carry = 0;
        while (l1 > 0 || l2 > 0 || carry > 0){
            int temp = carry;
            if (l1 > 0){
                temp += str1.charAt(l1) - '0';
                l1--;
            }

            if (l2 > 0){
                temp += str1.charAt(l2) - '0';
                l2--;
            }
            carry = temp/10;
            builder.append(temp % 10);
        }
        return builder.reverse().toString();
    }
}
