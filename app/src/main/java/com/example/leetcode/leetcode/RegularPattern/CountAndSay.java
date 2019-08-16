package com.example.leetcode.leetcode.RegularPattern;

import java.util.HashMap;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 *
 * 注意：整数顺序将表示为一个字符串。
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 1; i < n; i++){
            StringBuilder builder = new StringBuilder();
            char pre = str.charAt(0);
            int count = 1;
            for (int j=1; j < str.length(); j++){
                char c = str.charAt(j);
                if (c == pre){
                    count ++;
                }else {
                    builder.append(count).append(pre);
                    pre = c;
                    count = 1;
                }

            }
            builder.append(count).append(pre);
            str = builder.toString();
        }
        return str;
    }
}
