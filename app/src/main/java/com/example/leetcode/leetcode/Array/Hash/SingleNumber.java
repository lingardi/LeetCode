package com.example.leetcode.leetcode.Array.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int i = 0;
        int count ;
        for (; i < nums.length; i++){
            count = 0;
            for (int j = 0; j < nums.length; j++){
                if (nums[i] == nums[j])
                    count++;
                if (count == 2)
                    break;
            }
            if (count == 1)
                break;
        }
        return nums[i];
    }

    /**
     * 也可以使用hashSet不允许添加重复数据这一点
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (Integer i : nums){
            Integer count = hash.get(i);
            if (count == null) {
                count = 1;
            }else {
                count ++;
            }
            hash.put(i, count);
        }
        for (Integer i : hash.keySet()){
            if (hash.get(i) == 1)
                return i;
        }
        return -1;
    }

    /**
     * 异或，将数组所有数遍历一遍，所有相同的数异或之后都为0，再异或result得到result
     * @param nums
     * @return
     */
    public  int SingleNumber(int[] nums)
    {
        //注意，这里为0而不是其它值得原因并不是盲目的：甲 按位异或 0 得 甲，甲 按位异或 甲 得 0
        int result = 0;
        for (int i = 0; i < nums.length; i++)
        {
            result = result ^ nums[i];
        }
        return result;
    }

}
