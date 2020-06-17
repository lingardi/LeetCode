package com.example.leetcode.leetcode.BitCalculate;

/**
 * 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
 *
 * 示例1:
 *
 *  输入：num = 2（或者0b10）
 *  输出：[4, 1] 或者（[0b100, 0b1]）
 * 示例2:
 *
 *  输入：num = 1
 *  输出：[2, -1]
 * 提示:
 *
 * num的范围在[1, 2147483647]之间；
 * 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
 */
public class FindClosedNumbers {
    /**
     * 寻找大数字：从右往左遇到第一个01并替换为10，再将右边位数全部置0，保持1的个数相同
     * 寻找小数字：从右往左遇到第一个10并替换为01，再将右边位数全部置1，保持1的个数相同
     * @param num
     * @return
     */
    public int[] findClosedNumbers(int num) {
        int[] ans = new int[2];
        ans[1] = findSmall(num);
        ans[0] = findBig(num);
        return ans;
    }

    private int findSmall(int num) {
        int ans = num;
        int cur = num;
        int mask = 0; //提取i、i+1位
        int maskSmall = 0; //寻找10
        int count = 0;
        for (int i = 0; cur != 0; i++){
            mask = (3 << i);
            maskSmall = (2 << i);

            if (((ans & mask) ^ maskSmall )== 0){
                ans &= ~(0x1 << (i+1)); // i+1位置0
                ans |= (0x1 << i);  //i位置1

                int tail = (0x1 << i) - 1;
                ans &= (~tail); //num尾部清0
                tail ^= (tail >> count);
                ans |= tail; // 右边位置1

                break;
            }
            if ((cur & 0x1) == 1)
                count++; //统计遇到第一个10时1的个数
            cur >>= 1;
        }

        return ans == num ? -1 : ans;
    }

    private int findBig(int num) {
        int ans = num;
        int cur = num;
        int count = 0;
        int mask;
        int maskBig;
        for (int i = 0; cur != 0; i++){
            mask = (3 << i);
            maskBig = (1 << i);
            if (((ans & mask) ^ maskBig) == 0){
                ans &= ~(0x1 << i);
                ans |= (0x1 << (i+1));

                int tail = 0xFFFFFFFF << i;  // 定义一个最后i位都是0的数
                num &= tail;                 // num后面i位清零
                tail = (0x1 << count) - 1; // 全部的1都挪到了最右侧
                num |= tail;
                break;
            }

            if ((cur & 0x1) == 1){
                count++;
            }
            cur >>= 1;
        }
        return ans == num ? -1 : ans;
    }
}
