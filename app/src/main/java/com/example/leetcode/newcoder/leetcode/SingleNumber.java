package com.example.leetcode.newcoder.leetcode;

public class SingleNumber {
    /**
     * 假如例子是 1 2 6 1 1 2 2 3 3 3, 3 个 1, 3 个 2, 3 个 3,1 个 6
     * 1 0 0 1
     * 2 0 1 0
     * 6 1 1 0
     * 1 0 0 1
     * 1 0 0 1
     * 2 0 1 0
     * 2 0 1 0
     * 3 0 1 1
     * 3 0 1 1
     * 3 0 1 1
     * 看最右边的一列 1001100111 有 6 个 1
     * 再往前看一列 0110011111 有 7 个 1
     * 再往前看一列 0010000 有 1 个 1
     * 我们只需要把是 3 的倍数的对应列写 0，不是 3 的倍数的对应列写 1
     * 也就是 1 1 0,也就是 6。
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        //考虑每一位
        for (int i = 0; i < 32; i++) {
            int count = 0;
            //考虑每一个数
            for (int j = 0; j < nums.length; j++) {
                //当前位是否是 1
                if ((nums[j] >>> i & 1) == 1) {
                    count++;
                }
            }
            //1 的个数是否是 3 的倍数，否则该位有出现一次的数字贡献
            if (count % 3 != 0) {
                ans = ans | 1 << i;
            }
        }
        return ans;
    }


    /**
     *通用公式
     * @param A
     * @return
     */
    public int singleNumber2(int[] A) {
        int x1 = 0, x2 = 0, x3  = 0, mask = 0;
        for (int i : A) {
            x3 ^= x2 & x1 & i;
            x2 ^= x1 & i;
            x1 ^= i;
            mask = ~(x1 & ~x2 & x3);
            x3 &= mask;
            x2 &= mask;
            x1 &= mask;
        }
        return x1;
    }
}
