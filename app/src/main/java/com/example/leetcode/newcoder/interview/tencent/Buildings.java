package com.example.leetcode.newcoder.interview.tencent;

import java.util.Scanner;
import java.util.Stack;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/35fac8d69f314e958a150c141894ef6a
 * 来源：牛客网
 *
 * 小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
 * 小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，所以他想知道他在每栋楼的位置处能看到多少栋楼呢？（当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）
 *
 * 输入描述:
 * 输入第一行将包含一个数字n，代表楼的栋数，接下来的一行将包含n个数字wi(1<=i<=n)，代表每一栋楼的高度。
 * 1<=n<=100000;
 * 1<=wi<=100000;
 *
 *
 * 输出描述:
 * 输出一行，包含空格分割的n个数字vi，分别代表小Q在第i栋楼时能看到的楼的数量。
 * 示例1
 * 输入
 * 6
 * 5 3 8 3 2 5
 * 输出
 * 3 3 5 4 4 4
 * 说明
 * 当小Q处于位置3时，他可以向前看到位置2,1处的楼，向后看到位置4,6处的楼，加上第3栋楼，共可看到5栋楼。当小Q处于位置4时，他可以向前看到位置3处的楼，向后看到位置5,6处的楼，加上第4栋楼，共可看到4栋楼。
 */
public class Buildings {
    /**
     * 使用单调栈实现，开辟一个数组rightLook 保留往右看得到的数量，从右往左遍历，利用单调栈将看得到的数量保留在数组 rightLook 中 ，再从左往右遍历，获取往左看的计数
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0 ; i < len ; i++){
            arr[i] = sc.nextInt();
        }
        // stack中要保存的是 能看见的楼的 index
        int[] rightLook = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i = len - 1 ; i >= 0 ; i--){
            rightLook[i] = stack.size();
            while((!stack.isEmpty()) && (arr[i] >= arr[stack.peek()])){
                stack.pop();
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = 0 ; i < len ; i++){
            int total = rightLook[i] + 1 + stack.size();
            while((!stack.isEmpty()) && (arr[i] >= arr[stack.peek()])){
                stack.pop();
            }
            System.out.print(total + " ");
            stack.push(i);
        }
    }
}
