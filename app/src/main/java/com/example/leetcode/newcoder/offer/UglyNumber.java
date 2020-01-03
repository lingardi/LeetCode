package com.example.leetcode.newcoder.offer;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，
 * 因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class UglyNumber {
    /**
     * 三个指针，一个数组，逐个比较大小添加，只包括2、3、5
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index < 1)
            return 0;
        int[] dp = new int[index];
        dp[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int count = 0;
        int temp = 0;

        while (count < index -1){
            temp = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            if (temp == dp[i2] * 2)
                i2++;
            if (temp == dp[i3] * 3)
                i3++;
            if (temp == dp[i5] * 5)
                i5++;
            count++;
            dp[count] = temp;
        }
        return dp[count];
    }
}
