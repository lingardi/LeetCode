package com.example.leetcode.newcoder.interview.tencent;

import java.util.Random;

/**
 * 生成长度为n的int型随机数组，数组元素范围为0~n-1，每个元素都是唯一的。只使用基本数据类型
 */
public class ArrayBuild {
    private static int range = 100;
    private static int[] result;

    public static void main(String args[]) {
        result = getNumber(range);
        for (int i = 0; i < range; i++) {
            System.out.print(result[i] + ", ");
        }
    }

    /**
     * (1) 把N个数放到容器A(int数组)中.
     * (2) 从N个数中随机取出1个数放入容器B(int数组)中.
     * (3) 把容器A中最后一个数与随机抽取的数对调 或者 把容器A中最后一个数覆盖随机抽取出来的数.
     * (4) 这时从容器A(假设N个数,索引0 到 索引N-2)之间随机取一个数.再放入容器B中,重复此步骤.
     * @param total
     * @return
     */
    public static int[] getNumber(int total){
        int[] NumberBox = new int[total];			//容器A
        int[] rtnNumber = new int[total];			//容器B

        for (int i = 0; i < total; i++){
            NumberBox[i] = i;		//先把N个数放入容器A中
        }
        int end = total - 1;

        for (int j = 0; j < total; j++){
            int num = new Random().nextInt(end + 1);	//取随机数
            rtnNumber[j] = NumberBox[num];			//把随机数放入容器B
            NumberBox[num] = NumberBox[end];			//把容器A中最后一个数覆盖所取的随机数
            end--;									//缩小随机数所取范围
        }
        return rtnNumber;							//返回int型数组
    }
}
