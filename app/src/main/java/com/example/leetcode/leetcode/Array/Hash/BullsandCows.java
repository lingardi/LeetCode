package com.example.leetcode.leetcode.Array.Hash;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，
 * 你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），
 * 有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
 *
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
 *
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
 *
 * 示例 1:
 *
 * 输入: secret = "1807", guess = "7810"
 *
 * 输出: "1A3B"
 *
 * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
 * 示例 2:
 *
 * 输入: secret = "1123", guess = "0111"
 *
 * 输出: "1A1B"
 *
 * 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
 * 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。
 */
public class BullsandCows {
    /**
     * 先把bulls全部找到，对于不是bulls的将guess对应位置的字符用list，secret对应位置的字符和出现次数用map存起来
     * 再把cows全部找到，遍历list，判断map是否含有，找到一个cows，则处理相应的出现次数
     * @param secret
     * @param guess
     * @return
     */
    public static String getHint(String secret, String guess) throws SQLDataException {
        int aCount = 0;
        int bCount = 0;
        if (secret.length() == 0)
            throw new SQLDataException();
        ArrayList<Character> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char temp = secret.charAt(i);
            if (temp == guess.charAt(i))
                aCount++;
            else {
                list.add(guess.charAt(i));
                if (map.containsKey(temp))
                    map.put(temp, map.get(temp) + 1);
                else
                    map.put(temp, 1);
            }
        }
        for (Character c : list) {
            if (map.containsKey(c)) {
                bCount++;
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                    map.remove(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        ans.append(aCount).append("A").append(bCount).append("B");
        return ans.toString();
    }

    public static void main(String[] args) throws TokenException {
        try {
            getHint("1123", "0111");
        } catch (SQLDataException e) {
            throw new TokenException();
        }
    }

    private static class TokenException extends Throwable {
    }
}
