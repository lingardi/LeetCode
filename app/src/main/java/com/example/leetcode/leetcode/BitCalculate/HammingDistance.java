package com.example.leetcode.leetcode.BitCalculate;


/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *       ↑  ↑
 *上面的箭头指出了对应二进制位不同的位置。
 */
public class HammingDistance {
    /**
     * 异或，统计1的个数
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int ans = x ^ y;
        //直接统计1的个数
        return Integer.bitCount(ans);
//        int result = 0;
//        String binary = Integer.toBinaryString(ans);
//        for (int i =0; i < binary.length(); i++){
//            if (binary.charAt(i) == '1')
//                result++;
//        }
//        return result;
    }

    public int hammingDistance2(int x, int y) {
        int ans = 0;
        while (x!=0 || y!=0){
            if ((x & 1) != (y & 1))
                ans++;
            x >>= 1;
            y >>= 1;
        }
        return ans;
    }
}
