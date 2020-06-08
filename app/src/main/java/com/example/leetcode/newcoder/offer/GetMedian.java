package com.example.leetcode.newcoder.offer;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
@RequiresApi(api = Build.VERSION_CODES.N)
public class GetMedian {
    PriorityQueue<Integer> min = new PriorityQueue<>();
    //最大堆
    PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    int count = 0;
    /**
     * 维护两个堆分别存放小数据和大数据，大堆是最大堆小数据，小堆是最小堆大数据
     * 奇数个数据时插入大堆，偶数时插入小堆，维护两个堆堆顶的大小顺序
     * @param num
     */
    public void Insert(Integer num) {
        count++;

        if (count % 2 == 1){
            if (!min.isEmpty() && num > min.peek()){
                min.offer(num);
                num = min.poll();
            }
            max.offer(num);
        }else {
            if (!max.isEmpty() && num < max.peek()){
                max.offer(num);
                num = max.poll();
            }
            min.offer(num);
        }
    }

    public Double GetMedian() {
        if (count == 0)
            return 0d;
        if (count % 2 == 1){
            return Double.valueOf(max.peek());
        }else {
            return Double.valueOf((max.peek() + min.peek()) / 2.0);
        }

    }
}
